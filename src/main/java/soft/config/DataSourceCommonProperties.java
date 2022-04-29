package soft.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = DataSourceCommonProperties.DS, ignoreUnknownFields = false)
public class DataSourceCommonProperties {
	final static String DS = "spring.datasource.common-config";
 
	private int initialSize = 5;
	private int minIdle;
	private int maxActive = 20;
	//连接等待超时时间
	private int maxWait;
	//配置隔多久进行一次检测(检测可以关闭的空闲连接)
	private int timeBetweenEvictionRunsMillis;
	//配置连接在池中的最小生存时间
	private int minEvictableIdleTimeMillis;
	private String validationQuery;
	private boolean testWhileIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	//打开PSCache，并且指定每个连接上PSCache的大小
	private boolean poolPreparedStatements;
 	private int maxPoolPreparedStatementPerConnectionSize;
}