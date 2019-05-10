package cn.bzu.jobprovider.db;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {
    private static String url = "jdbc:mysql://localhost:3306/worker";
    private static String user = "root";
    private static String password = "199703";
    private static String dirverName = "com.mysql.jdbc.Driver";
    private static String author = "津少";
    private static String outputDir = "jobprovider\\src\\main\\java\\cn\\bzu\\jobprovider";

    public static void main(String[] args) {
        GlobalConfig config = new GlobalConfig();
        //数据库配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(url)
                .setUsername(user)
                .setPassword(password)
                .setDriverName(dirverName);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setEntity("pojo");
        pc.setController("controller");
        pc.setMapper("dao");
        pc.setParent("domion");


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(pc.getModuleName() + "_");

        config.setEnableCache(false).
                setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true)
                .setServiceName("%sService")

                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setActiveRecord(true)
                .setOpen(false);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(pc).execute();
    }
}
