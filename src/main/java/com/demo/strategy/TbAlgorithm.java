package com.demo.strategy;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

/**
 * 
 * 创建时间:2017年2月23日
 * @author jiangjianbin
 *
 */
public class TbAlgorithm implements SingleKeyTableShardingAlgorithm<Integer>{

	public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
		 Collection<String> result = new LinkedHashSet<>(tableNames.size());  
	        Range<Integer> range = (Range<Integer>) shardingValue.getValueRange();  
	        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {  
	            for (String each : tableNames) {  
	                if (each.endsWith(i % 2 + "")) {  
	                    result.add(each);  
	                }  
	            }  
	        }  
	        return result;
	}

	public String doEqualSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
		  int id = shardingValue.getValue();  
		  
	        int index = id % 2;  
	  
	        for (String each : tableNames) {  
	            if (each.endsWith(index + "")) {  
	                return each;  
	            }  
	        }  
	        throw new UnsupportedOperationException();  
	}

	public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
		 Collection<String> result = new LinkedHashSet<>(tableNames.size());  
	        for (Integer value : shardingValue.getValues()) {  
	            for (String tableName : tableNames) {  
	                if (tableName.endsWith(value % 2 + "")) {  
	                    result.add(tableName);  
	                }  
	            }  
	        }  
	        return result; 
	}

}
