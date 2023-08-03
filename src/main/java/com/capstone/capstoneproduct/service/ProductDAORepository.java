/*
 * package com.capstone.capstoneproduct.service;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.capstone.capstoneproduct.entity.Product;
 * 
 * @Repository public class ProductDAORepository implements ProductDAO {
 * 
 * @Autowired JdbcTemplate jt;
 * 
 * @Autowired DataSource ds;
 * 
 * @Override public boolean postProduct(Product product) throws SQLException {
 * // TODO Auto-generated method stub String query =
 * "insert into product (p_name, image_id, p_price, p_description) values (?,?,?,?)"
 * ; int i = jt.update(query, new Object[] { product.getP_name(),
 * product.getImage_id(), product.getP_price(), product.getP_description()});
 * if(i>0) return true; else return false; }
 * 
 * @Override public boolean updateProduct(Product product, int id) throws
 * SQLException { // TODO Auto-generated method stub Connection con =
 * ds.getConnection(); String query = "select * from product where p_id = " +
 * id; PreparedStatement ps = con.prepareStatement(query); if(ps.execute()) {
 * query =
 * "update product set p_name = ?, image_id = ?, p_price = ?, p_description = ? where p_id = "
 * + id; ps = con.prepareStatement(query); ps.setString(1, product.getP_name());
 * ps.setString(2, product.getImage_id()); ps.setDouble(3,
 * product.getP_price()); ps.setString(4, product.getP_description());
 * if(ps.executeUpdate()>0) return true; else return false; } else return false;
 * }
 * 
 * @Override public Product getProduct(int id) throws SQLException { // TODO
 * Auto-generated method stub Connection con = ds.getConnection(); String query
 * = "select * from product where p_id = " + id; PreparedStatement ps =
 * con.prepareStatement(query); ResultSet rs = ps.executeQuery(); Product p =
 * new Product(); while(rs.next()) { p.setP_id(rs.getInt(1));
 * p.setP_name(rs.getString(2)); p.setImage_id(rs.getString(3));
 * p.setP_price(rs.getDouble(4)); p.setP_description(rs.getString(5)); } return
 * p; }
 * 
 * @Override public List<Product> getProductByCategories() { // TODO
 * Auto-generated method stub return null; }
 * 
 * }
 */