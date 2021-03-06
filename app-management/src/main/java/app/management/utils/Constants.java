package app.management.utils;

/**
 * This class includes the constance used in the licensekey.generator package.
 *
 * @since 1.0.0
 */
public class Constants {

    private Constants() {

    }

    /**
     * Configuration constants.
     */
    public static class Configurations {

        public static final String CONFIGURATION_YAML = "licensekeygenerator.yaml";
    }

    /**
     * Database constants.
     */
    public static class Database {

        public static final String PERSISTENCE_UNIT_NAME = "app.management.model.ApplicationData";
        public static final String JDBC_URL = "javax.persistence.jdbc.url";
        public static final String JDBC_USER = "javax.persistence.jdbc.user";
        public static final String JDBC_PASSWORD = "javax.persistence.jdbc.password";
        public static final String C3P0_MAX_CONNECTION_POOL_SIZE = "hibernate.c3p0.max_size";

        /**
         * Database Queries Constants.
         */
        public static class Queries {

            public static final String LIST_ALL_APPLICATION = "getAllApps";
            public static final String GET_ALL_APPLICATION = "SELECT * FROM APPLICATION_INFO";
        }

    }
}
