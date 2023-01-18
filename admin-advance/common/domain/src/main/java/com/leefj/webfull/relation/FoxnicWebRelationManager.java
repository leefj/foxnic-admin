package com.leefj.webfull.relation;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.relation.RelationManager;
import com.leefj.webfull.relation.modules.ExampleRelationManager;
import org.github.foxnic.web.relation.modules.*;

public class FoxnicWebRelationManager extends RelationManager {

	public FoxnicWebRelationManager() {
		super(

				// 需要加载的通用模块关系
				new OAuthRelationManager(),
				new SystemRelationManager(),
				new HrmRelationManager(),
				new CodeExampleRelationManager(),
				new PcmRelationManager(),
				new BpmRelationManager(),
				new DataPermRelationManager(),
				new JobRelationManager(),

				// 当前项目模块的关系
				new ExampleRelationManager()
		);
	}

	public void startMonitor() {
			SimpleTaskManager tm=new SimpleTaskManager();
			tm.doIntervalTask(new Runnable() {
				@Override
				public void run() {
//					doReConfigAndValidate();
				}
			}, 5000);
	}


	protected void doReConfigAndValidate() {
		FoxnicWebRelationManager.this.reconfig();
		Logger.info("FoxnicWebRelationManager Reconfig");
	}


	@Override
	protected void config() {}






}
