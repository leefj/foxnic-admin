package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.util.ModuleCodeGenerator;
import org.github.foxnic.web.generator.module.bpm.ExampleReimbursementConfig;
import org.github.foxnic.web.generator.module.mall.ExampleAddressConfig;
import org.github.foxnic.web.generator.module.mall.ExampleGoodsConfig;
import org.github.foxnic.web.generator.module.mall.ExampleOrderConfig;
import org.github.foxnic.web.generator.module.mall.ExampleOrderItemConfig;
/**
 * 代码生成启动类
 * */
public class WebFullCodeStarter extends ModuleCodeGenerator {
    public static void main(String[] args) {
        // 新建启动类对象
        WebFullCodeStarter g=new WebFullCodeStarter();
        // 初始化本次需要生成代码的模块
        g.initModules();
        // 启动
        g.start();
    }
    /**
     * 初始化本次需要生成代码的模块
     * */
    public void initModules() {
        initExampleModules();
        initBPMModules();
    }
    /**
     * 初始化 BPM 示例模块
     * */
    private void initBPMModules() {
         this.addConfig(new ExampleReimbursementConfig());
    }
    /**
     * 初始化订单示例模块
     * */
    private void initExampleModules() {
        this.addConfig(new ExampleGoodsConfig());
        this.addConfig(new ExampleAddressConfig());
        this.addConfig(new ExampleOrderConfig());
        this.addConfig(new ExampleOrderItemConfig());
    }
}
