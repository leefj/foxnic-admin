package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import com.leefj.webfull.constants.db.WebFullTables;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_REIMBURSEMENT;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ExampleReimbursementConfig extends BaseCodeConfig<WebFullTables.WEBFULL_EXAMPLE_REIMBURSEMENT> {


    /**
     * 配置模型，为 po 和 vo 添加 额外的属性等
     */
    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {


    }

    /**
     * 配置字段
     */
    @Override
    public void configFields(ViewOptions view) {

        // ID 字段通常隐藏
        view.field(WEBFULL_EXAMPLE_REIMBURSEMENT.ID).basic().hidden();

        // NAME 字段，单行文本框
        view.field(WEBFULL_EXAMPLE_REIMBURSEMENT.TITLE)
                // 搜索栏：设置模糊搜索
                .search().fuzzySearch()
                // 表格列：指定对齐方式
                .table().alignLeft()
                // 表单：指定表单编辑器为文本输入框，并指定默认值
                .form().textInput()
                // 表单校验：必填
                .form().validate().required()
        ;

        // NAME 字段，单行文本框
        view.field(WEBFULL_EXAMPLE_REIMBURSEMENT.AMOUNT)
                // 搜索栏：设置模糊搜索
                .search().range()
                // 表格列：指定对齐方式
                .table().alignRight()
                // 表单：指定表单编辑器为文本输入框，并指定默认值
                .form().numberInput().decimal()
                // 表单校验：必填
                .form().validate().required()
        ;




    }

    @Override
    public void configBPM(BpmOptions bpm) {
        bpm.integrate(IntegrateMode.FRONT);
        bpm.form("webfull-reimbursement");
    }

    /**
     * 配置搜索
     */
    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

//        // 搜索布局
//        search.inputLayout(new Object[]{
//                WEBFULL_EXAMPLE_REIMBURSEMENT.NAME,WEBFULL_EXAMPLE_REIMBURSEMENT.PHONE_NUMBER,WEBFULL_EXAMPLE_REIMBURSEMENT.ADDRESS,"keyword"
//        },new Object[]{
//                WEBFULL_EXAMPLE_REIMBURSEMENT.REGION_TYPE,WEBFULL_EXAMPLE_REIMBURSEMENT.REGION_LOCATION,WEBFULL_EXAMPLE_REIMBURSEMENT.CREATE_TIME
//        });
//
//
//
//        // 设置标签宽度
//        search.labelWidth(1,65);
//        // 设置标签宽度
//        search.labelWidth(2,75);
//        // 设置标签宽度
//        search.labelWidth(3,75);
//
//        // 个别输入框宽度调整
//        view.field(WEBFULL_EXAMPLE_REIMBURSEMENT.ADDRESS).search().inputWidth(296);


    }

    /**
     * 配置 List 表格
     */
    @Override
    public void configList(ViewOptions view, ListOptions list) {

    }

    /**
     * 配置表单
     */
    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

//        formWindow.width("700px");
//
        form.labelWidth(70);





    }




    /**
     * 配置源码覆盖
     */
    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        context.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

    /**
     * 配置服务代码
     */
    @Override
    public void configService(ServiceOptions service) {

    }


    public ExampleReimbursementConfig() {
        super("webfull-service-example", WebFullTables.WEBFULL_EXAMPLE_REIMBURSEMENT.$TABLE, "webfull_example_");
    }


}
