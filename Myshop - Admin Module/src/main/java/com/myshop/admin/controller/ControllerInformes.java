package com.myshop.admin.controller;

import java.util.List;
import java.util.Map;

import org.sql2o.Connection;

import com.myshop.admin.util.DefaultSql2o;

public class ControllerInformes {

	
	public List<Map<String,Object>> primerInforme() {
		//TODO
		return null;
	}
	
	public List<Map<String,Object>> segundoInforme() {
		//TODO
		return null;
	}
	
	public List<Map<String,Object>> tercerInforme() {
		String complexSql = "SELECT count(*) as suma , wk_id , date_received FROM myshop."
				+ "full_order where status='finalizado' order by wk_id , date_received ";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
	
	public List<Map<String,Object>> cuartoInforme() {
		String complexSql = "SELECT count(*) as suma , p.wk_id , w.date_completed FROM myshop."
				+ "full_order p , myshop.working_plan w where w.wp_id=p.working_plan_id and w.date_completed <> null "
				+ "order by p.wk_id , w.date_completed ";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
}