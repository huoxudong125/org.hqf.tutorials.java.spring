package org.hqf.spring.transcaction.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao  {


	public void increaseMoney(Integer id, Double money) {
		
		getJdbcTemplate().update("update t_account set money = money+? where id = ? ", money,id);
		
	}


	public void decreaseMoney(Integer id, Double money) {

		getJdbcTemplate().update("update t_account set money = money-? where id = ? ", money,id);
	}

}
