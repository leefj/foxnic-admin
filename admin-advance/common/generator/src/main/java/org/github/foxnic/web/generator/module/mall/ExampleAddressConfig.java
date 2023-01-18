package org.github.foxnic.web.generator.module.mall;

import com.github.foxnic.api.query.MatchType;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import com.leefj.webfull.constants.db.WebFullTables.WEBFULL_EXAMPLE_ADDRESS;
import com.leefj.webfull.constants.enums.WebFullDictEnum;
import com.leefj.webfull.constants.enums.dict.RegionLocation;
import com.leefj.webfull.constants.enums.example.RegionType;
import com.leefj.webfull.domain.example.Goods;
import com.leefj.webfull.domain.example.Order;
import com.leefj.webfull.domain.example.OrderItem;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ExampleAddressConfig extends BaseCodeConfig<WEBFULL_EXAMPLE_ADDRESS> {


    /**
     * 配置模型，为 po 和 vo 添加 额外的属性等
     */
    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        // 1、为 po 添加属性
        poType.addSimpleProperty(Integer.class, "orderCount", "订单量", "每年收到的订单数量");
		poType.addListProperty(Goods.class,"goodsList","订单明细商品","订单明细商品");
		poType.addListProperty(OrderItem.class,"itemList","订单明细","订单明细");
		poType.addListProperty(Order.class,"orderList","订单","订单");

        // 2、为 vo 添加属性
        voType.addSimpleProperty(String.class, "keyword", "关键字", "查询关键字");

        // 3、单独创建一个 Model
        PojoClassFile addressModel = context.createPojo("AddressModel");
        // 使继承自 Entity
        addressModel.setSuperType(Entity.class);
        // 添加一个自定义属性
        addressModel.addSimpleProperty(String.class, "myProperty", "自定义属性", "我的自定义属性");
        // 使用字段构建器构建
        FieldsBuilder fields = this.createFieldsBuilder();
        fields.addAll().removeDBTreatyFields();
        // 添加字段构建器作为字段构建的来源
        addressModel.addSimpleProperties(fields);

        // 4、定义一个子类型
        PojoClassFile addressSubModel = context.createPojo("AddressSubModel");
        addressSubModel.setSuperTypeFile(addressModel);
        addressSubModel.addSimpleProperty(String.class, "postCode1", "邮编1", "邮编1");
        addressSubModel.addSimpleProperty(String.class, "postCode2", "邮编2", "邮编2");

        // 5、定义一个没有父类的对象模型
        PojoClassFile addressPureModel = context.createPojo("AddressPureModel");
        addressPureModel.noSuperType();
        fields = this.createFieldsBuilder();
        fields.addAll().removeDBTreatyFields();
        addressPureModel.addSimpleProperties(fields);
    }

    /**
     * 配置字段
     */
    @Override
    public void configFields(ViewOptions view) {

        // ID 字段通常隐藏
        view.field(WEBFULL_EXAMPLE_ADDRESS.ID)
                // 基础配置，可通过 form、search、table 覆盖。
                .basic().hidden();

        // ID 字段通常隐藏
        view.field(WEBFULL_EXAMPLE_ADDRESS.ID)
                // 基础配置，可通过 form、search、table 覆盖。
                .basic().hidden();

        // NAME 字段，单行文本框
        view.field(WEBFULL_EXAMPLE_ADDRESS.NAME)
                // 基础设置：指定标签值
                .basic().label("收件人")
                // 搜索栏：设置模糊搜索
                .search().fuzzySearch()
                // 表格列：指定对齐方式
                .table().alignLeft()
                // 表单：指定表单编辑器为文本输入框，并指定默认值
                .form().textInput().defaultText("乔峰")
                // 表单校验：必填
                .form().validate().required()
        ;

        // PHONE_NUMBER 字段，单行文本框
        view.field(WEBFULL_EXAMPLE_ADDRESS.PHONE_NUMBER)
                // 基础设置：指定标签值
                .basic().label("手机号码")
                // 搜索栏：设置模糊搜索
                .search().fuzzySearch()
                // 表格列：指定对齐方式
                .table().alignLeft()
                // 表单：指定表单编辑器为文本输入框，并指定默认值
                .form().textInput().defaultText("137")
                // 表单校验：必填 + 手机号校验
                .form().validate().required().phone()
        ;

        // ADDRESS 字段，单行文本框
        view.field(WEBFULL_EXAMPLE_ADDRESS.ADDRESS)
                // 搜索栏：设置模糊搜索
                .search().fuzzySearch()
                // 表格列：指定对齐方式
                .table().alignLeft()
                // 表单：指定表单编辑器为文本输入框，并指定默认值
                .form().textInput().defaultText("浙江省宁波市")
                // 表单校验：必填
                .form().validate().required();
        ;

        // NOTES 字段，多行文本框
        view.field(WEBFULL_EXAMPLE_ADDRESS.NOTES)
                // 搜索栏：设置为隐藏
                .search().hidden()
                // 表格列：指定对齐方式
                .table().alignLeft()
                // 表单：指定表单编辑器为文本输入框，并指定高度
                .form().textArea().height(100)
        ;


        // REGION_TYPE 字段，使用枚举
        view.field(WEBFULL_EXAMPLE_ADDRESS.REGION_TYPE)
                // 表格列：指定对齐方式
                .table().alignCenter()
                // 表单：指定表单编辑器为单选框，并指定数据源，默认值
                // .form().radioBox().enumType(RegionType.class).defaultIndex(0)
                // 表单：指定表单编辑器为下拉选择，并指定数据源，默认值
                .form().selectBox().enumType(RegionType.class).defaultValue(RegionType.INLAND)
                // 表单：指定表单编辑器为复选框，并指定数据源，默认值
                // .form().checkBox().enumType(RegionType.class).defaultValue(RegionType.INLAND,RegionType.FOREIGN)
                // 搜索：多选搜索，触发查询
                .search().selectMuliti(true).triggerOnSelect(true);
        ;


        // REGION_LOCATION 字段，使用字典
        view.field(WEBFULL_EXAMPLE_ADDRESS.REGION_LOCATION)
                // 表格列：指定对齐方式
                .table().alignCenter()
                // 表单：指定表单编辑器为单选框，并指定数据源，默认值
                // .form().radioBox().dict(WebFullDictEnum.REGION_LOCATION).defaultIndex(0)
                // 表单：指定表单编辑器为下拉选择，并指定数据源，默认值
                // .form().selectBox().dict(WebFullDictEnum.REGION_LOCATION).defaultValue(RegionLocation.DONGBEI)
                // 表单：指定表单编辑器为复选框，并指定数据源，默认值
                .form().checkBox().dict(WebFullDictEnum.REGION_LOCATION).defaultValue(RegionLocation.DONGBEI,RegionLocation.HUANAN)
                // 搜索：多选搜索，触发查询
                .search().selectMuliti(true).triggerOnSelect(true);
        ;


        // CREATE_TIME 字段，使用日期
        view.field(WEBFULL_EXAMPLE_ADDRESS.CREATE_TIME)
                // 针对规约字段需要额外设置不隐藏
                .search().hidden(false)
                // 指定按范围搜索
                .search().range(true).matchType(MatchType.auto)
                .triggerOnSelect(true)
        ;

        // ADDRESS 字段，单行文本框
        view.field("keyword")
                // 搜索栏：设置模糊搜索
                .search().label("关键字")
        ;


    }

    /**
     * 配置搜索
     */
    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

        // 搜索布局
        search.inputLayout(new Object[]{
                WEBFULL_EXAMPLE_ADDRESS.NAME,WEBFULL_EXAMPLE_ADDRESS.PHONE_NUMBER,WEBFULL_EXAMPLE_ADDRESS.ADDRESS,"keyword"
        },new Object[]{
                WEBFULL_EXAMPLE_ADDRESS.REGION_TYPE,WEBFULL_EXAMPLE_ADDRESS.REGION_LOCATION,WEBFULL_EXAMPLE_ADDRESS.CREATE_TIME
        });



        // 设置标签宽度
        search.labelWidth(1,65);
        // 设置标签宽度
        search.labelWidth(2,75);
        // 设置标签宽度
        search.labelWidth(3,75);

        // 个别输入框宽度调整
        view.field(WEBFULL_EXAMPLE_ADDRESS.ADDRESS).search().inputWidth(296);


    }

    /**
     * 配置 List 表格
     */
    @Override
    public void configList(ViewOptions view, ListOptions list) {

        // 设置默认排序
        list.sort(WEBFULL_EXAMPLE_ADDRESS.PHONE_NUMBER, true);

    }

    /**
     * 配置表单
     */
    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

        formWindow.width("700px");

        form.labelWidth(85);

        form.addGroup("基本信息",new Object[]{
                WEBFULL_EXAMPLE_ADDRESS.NAME,
        },new Object[]{
                WEBFULL_EXAMPLE_ADDRESS.PHONE_NUMBER,
        });
        form.addGroup("扩展信息",new Object[]{
                WEBFULL_EXAMPLE_ADDRESS.ADDRESS,
                WEBFULL_EXAMPLE_ADDRESS.REGION_TYPE,
                WEBFULL_EXAMPLE_ADDRESS.REGION_LOCATION,
                WEBFULL_EXAMPLE_ADDRESS.NOTES
        });



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









    public ExampleAddressConfig() {
        super("webfull-service-example", WEBFULL_EXAMPLE_ADDRESS.$TABLE, "webfull_example_");
    }


}
