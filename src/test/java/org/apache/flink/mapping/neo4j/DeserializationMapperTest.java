/**
 * 
 */
package org.apache.flink.mapping.neo4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.mapping.neo4j.DeserializationMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alberto De Lazzari
 *
 */
public class DeserializationMapperTest {

	class StringValuesMapper implements DeserializationMapper<String> {

		private static final long serialVersionUID = 1L;

		@Override
		public Map<String, Object> deserialize(String item) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("key", item);
			return map;
		}
	}

	@Test
	public void testStringValuesMapper() {
		StringValuesMapper stringValuesMapper = new StringValuesMapper();

		String item = "item";
		Map<String, Object> map = stringValuesMapper.deserialize(item);

		Assert.assertNotNull(map);
		Assert.assertTrue(!map.isEmpty());

		Object value = map.get("key");
		Assert.assertNotNull(value);
		Assert.assertArrayEquals(new String[] { "item" }, new String[] { value.toString() });
	}
}