package jdby.core;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public interface SqlParameter {

    void set(PreparedStatement ps, int index) throws SQLException;

    static SqlParameter pInt(Integer x) {
        return jdbc(x, JDBCType.INTEGER);
    }

    static SqlParameter pLong(Long x) {
        return jdbc(x, JDBCType.BIGINT);
    }

    static SqlParameter pDouble(Double x) {
        return jdbc(x, JDBCType.DOUBLE);
    }

    static SqlParameter pDecimal(BigDecimal x) {
        return jdbc(x, JDBCType.DECIMAL);
    }

    static SqlParameter pBoolean(Boolean x) {
        return jdbc(x, JDBCType.BOOLEAN);
    }

    static SqlParameter pString(String x) {
        return jdbc(x, JDBCType.VARCHAR);
    }

    static SqlParameter pBytes(byte[] x) {
        return jdbc(x, JDBCType.VARBINARY);
    }

    static SqlParameter pDate(LocalDate x) {
        return jdbc(x, JDBCType.DATE);
    }

    static SqlParameter pDateTime(LocalDateTime x) {
        return jdbc(x, JDBCType.TIMESTAMP);
    }

    static SqlParameter pDateTime(OffsetDateTime x) {
        return jdbc(x, JDBCType.TIMESTAMP_WITH_TIMEZONE);
    }

    static SqlParameter jdbc(Object x, JDBCType type) {
        return new SimpleSqlParameter(x, type);
    }
}
