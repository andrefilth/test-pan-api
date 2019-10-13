//package com.andre.customer.client.model.mapper;
//
//import com.andre.customer.client.model.Customer;
//import org.jdbi.v3.core.mapper.RowMapper;
//import org.jdbi.v3.core.statement.StatementContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static com.andre.customer.client.model.util.MapperUtil.toZonedDateTime;
//
//public class CustomerMapper implements RowMapper<Customer> {
//
//    private static final Logger LOG;
//
//    static {
//        LOG = LoggerFactory.getLogger(CustomerMapper.class);
//    }
//
//
//    @Override
//    public Customer map(ResultSet rs, StatementContext ctx) throws SQLException {
//        LOG.info("Mapeando customer: " );
//        return Customer.builder()
//                .setId(rs.getLong("id"))
//                .setName(rs.getString("name"))
//                .setDocument(rs.getString("document"))
////                .setCreatedAt(toZonedDateTime(rs.getTimestamp("created_at").toLocalDateTime()))
////                .setUpdateAt(toZonedDateTime(rs.getTimestamp("update_at").toLocalDateTime()))
//                .build();
//    }
//}
