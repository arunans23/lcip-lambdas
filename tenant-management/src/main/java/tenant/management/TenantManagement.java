package tenant.management;

import org.json.simple.JSONObject;
import tenant.management.dao.UpdateDB;
import tenant.management.manager.TenantManager;
import tenant.management.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TenantManagement {

    private static UpdateDB updateDB;

    static {
        Map<String, Object> jdbcConfig = new HashMap<>();

        String jdbcUrl = System.getenv("jdbcUrl");
        if (jdbcUrl == null || jdbcUrl.isEmpty()) {
            jdbcUrl = "jdbc:mysql://localhost:3306/cloud_db?useSSL=false";
        }
        jdbcConfig.put(Constants.Database.JDBC_URL, jdbcUrl);

        String userName = System.getenv("userName");
        if (userName == null || userName.isEmpty()) {
            userName = "root";
        }
        jdbcConfig.put(Constants.Database.JDBC_USER, userName);

        String secret = System.getenv("password");
        if (secret == null || secret.isEmpty()) {
            secret = "root";
        }
        jdbcConfig.put(Constants.Database.JDBC_PASSWORD, secret);
        jdbcConfig.put(Constants.Database.C3P0_MAX_CONNECTION_POOL_SIZE, 30);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.Database.PERSISTENCE_UNIT_NAME,
                                                                          jdbcConfig);
        updateDB = new UpdateDB(emf, 3, 5000);
    }

    protected static TenantManager tenantManager = new TenantManager(updateDB);

    protected static JSONObject getErrorOutput(String message) {
        JSONObject output = new JSONObject();
        output.put("Status", "Internal Server Error");
        output.put("Message", message);
        return output;
    }

}
