package orm.model.table;

public enum SQLTableType {
    // ------ Numeric types ------ //
    BIT("BIT"),
    BOOLEAN("BOOLEAN"),

    TINY_INT("TINYINT"),
    UNSIGNED_TINY_INT("TINYINT UNSIGNED"),
    TINY_INT_ZERO_FILL("TINYINT ZEROFILL"),

    SMALLINT("SMALLINT"),
    UNSIGNED_SMALLINT("SMALLINT UNSIGNED"),
    SMALLINT_ZERO_FILL("SMALLINT ZEROFILL"),

    MEDIUM_INT("MEDIUMINT"),
    UNSIGNED_MEDIUM_INT("MEDIUMINT UNSIGNED"),

    INT("INT"),
    UNSIGNED_INT("INT UNSIGNED"),
    INT_ZERO_FILL("INT ZEROFILL"),
    
    BIGINT("BIGINT"),
    UNSIGNED_BIGINT("BIGINT UNSIGNED"),
    BIGINT_ZERO_FILL("BIGINT ZEROFILL"),

    DECIMAL("DECIMAL"),
    UNSIGNED_DECIMAL("DECIMAL UNSIGNED"),
    DECIMAL_ZERO_FILL("DECIMAL ZEROFILL"),

    FLOAT("FLOAT"),
    UNSIGNED_FLOAT("FLOAT UNSIGNED"),
    FLOAT_ZERO_FILL("FLOAT ZEROFILL"),

    DOUBLE("DOUBLE"),
    UNSIGNED_DOUBLE("DOUBLE UNSIGNED"),
    DOUBLE_ZERO_FILL("DOUBLE ZEROFILL"),

    DOUBLE_PRECISION("DOUBLE PRECISION"),
    UNSIGNED_DOUBLE_PRECISION("DOUBLE PRECISION UNSIGNED"),
    DOUBLE_PRECISION_ZEROFILL("DOUBLE PRECISION ZEROFILL"),

    REAL("REAL"),
    UNSIGNED_REAL("REAL UNSIGNED"),
    REAL_ZERO_FILL("REAL ZEROFILL"),

    // ----- literal types ----- //
    CHAR("CHAR"),
    VARCHAR("VARCHAR"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY"),
    TINYBLOB("TINYBLOB"),
    BLOB("BLOB"),
    TINYTEXT("TINYTEXT"),
    TEXT("TEXT"),
    MEDIUM_TEXT("MEDIUMTEXT"),
    LONG_TEXT("LONGTEXT"),
    JSON("JSON"),
    MEDIUM_BLOB("MEDIUMBLOB"),
    LONG_BLOB("LONGBLOB"),
    ENUM("ENUM"),
    SET("SET"),

    // ------ Date ------ //
    DATE("DATE"),
    TIME("TIME"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),
    YEAR("YEAR");

    public final String label;
    private SQLTableType(String label)
    {
        this.label = label;
    }

    @Override
    /**
     * @return the String representation of the enumeration
     */
    public String toString()
    {
        return this.label;
    }
}