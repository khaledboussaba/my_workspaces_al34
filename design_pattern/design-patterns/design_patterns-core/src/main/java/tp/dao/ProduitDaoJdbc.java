package tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.entity.Produit;

public class ProduitDaoJdbc implements ProduitDao {
	
	private static Logger logger = LoggerFactory.getLogger(ProduitDaoJdbc.class);
	
	private DataSource dataSource;
	
	/*// old version without IOC/injection
	private void initDataSource(){
		if(dataSource==null){
			dataSource = DataSourceFactory.getInstance().getDataSource();
		}
	}*/
	
	// new version with IOC/injection
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		logger.info("dataSource injected in ProduitDaoJdbc : " + dataSource.toString());
	}
	
	private Connection getSqlConnection(){
		Connection cn=null;
		try {
			/*initDataSource(); //for old version only (without ioc)*/
			cn = dataSource.getConnection();
		} catch (Exception e) {
					logger.error("database connection error", e);
		}
		return cn;
	}
	
	private static void closeConnection(Connection cn){
		try{ cn.close(); } catch(SQLException ex){ }
	}
	
	private void executeSql(String sql, Object ... args) throws RuntimeException
	{
		Connection cn = this.getSqlConnection();
		try {
			//Statement st = cn.createStatement();
		    //st.executeUpdate(sql);
			PreparedStatement st = cn.prepareStatement(sql);
			int i = 1;
			for(Object arg : args){
				if(arg!=null)
					st.setObject(i++, arg);
			}
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			 logger.error("sql exception", e);
			throw new RuntimeException(e.getMessage());
		}
		finally{
			closeConnection(cn);
		}
	}

	@Override
	public Produit createProduit(Produit nouveauProduit) {
		if(nouveauProduit.getReference()==null){
			Long pk= createProduitAutoIncr(nouveauProduit);
			nouveauProduit.setReference(pk);
		}
		else{
		   this.executeSql("insert into T_PRODUIT(ref,designation,prix_ht) VALUES(?1,?2,?3)",
				          nouveauProduit.getReference(), nouveauProduit.getLabel() ,nouveauProduit.getPrix());
		}
		return nouveauProduit;
	}
	
	public Long createProduitAutoIncr(Produit nouveauProduit) {
		Long pk=null;
		Connection cn = this.getSqlConnection();
		try {
			PreparedStatement pst = cn.prepareStatement("insert into T_PRODUIT(designation,prix_ht) VALUES(?1,?2)" ,
					                                    Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,nouveauProduit.getLabel());
			pst.setDouble(2,nouveauProduit.getPrix());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
		    if (rs.next()) {
		        pk = rs.getLong(1);
		    } else {
		    	logger.error("cannot retreive auto_increment key");
		    }
		    rs.close();
		    pst.close();
		} catch (SQLException e) {
			 logger.error("sql exception", e);
			throw new RuntimeException(e.getMessage());
		}
		finally{
			closeConnection(cn);
		}
		return pk;
	}

	@Override
	public void deleteProduit(Produit p) {
		this.executeSql("delete from T_PRODUIT where ref=?1",p.getReference());
	}

	@Override
	public List<Produit> getAllProduits() {
		List<Produit> listeProd = new ArrayList<Produit>();
		Connection cn = this.getSqlConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs  = st.executeQuery("select * from T_PRODUIT");
			while(rs.next()){
				listeProd.add(this.produitFromRs(rs));
			}
			rs.close();	st.close();
		} catch (SQLException e) {
			 logger.error("sql exception", e);
		}
		finally{
			closeConnection(cn);
		}
		return listeProd;
	}
	
	private Produit produitFromRs(ResultSet rs) throws SQLException
	{
		Produit prod=null;
		long ref= rs.getLong("ref");
		String label = rs.getString("designation");
		double prix  = rs.getDouble("prix_ht");
		prod=new Produit(ref,label,prix);	
		return prod;
	}
	
	/*
	private long getMaxRef() {
		long maxRef=0;
		Connection cn = this.getSqlConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs  = st.executeQuery("select max(REF) from T_PRODUIT");
			if(rs.next()){
			  maxRef=rs.getLong(1);
			}
			rs.close();	st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{ cn.close(); } catch(Exception ex){}
		}
		return maxRef;
	}*/

	@Override
	public Produit getProduitByRef(long ref) {
		Produit prod=null;
		Connection cn = this.getSqlConnection();
		try {
			PreparedStatement st = cn.prepareStatement("select * from T_PRODUIT where ref= ?1");
			st.setLong(1, ref);
			ResultSet rs  = st.executeQuery();
			if(rs.next()){
			  prod=this.produitFromRs(rs);
			}
			rs.close();	st.close();
		} catch (SQLException e) {
			 logger.error("sql exception", e);
		}
		finally{
			closeConnection(cn);
		}
		return prod;
	}

	@Override
	public void updateProduit(Produit p) {
		this.executeSql("update T_PRODUIT set designation=?1 ,prix_ht=?2 where ref=?3",
				        p.getLabel() , p.getPrix() , p.getReference());
	}

	@Override
	public void cleanUpResources() {
	}

}
