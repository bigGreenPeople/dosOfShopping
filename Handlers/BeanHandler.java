public class BeanHandler implements ResultSetHandler {
	private Class clazz;
	public BeanHandler(Class clazz) {
		this.clazz = clazz;
	}
	public Object handle(ResultSet rs) {
		// ��֪���м������ݣ���֪����������֪����װ��ʲô����bean
		// ���������javabean���ֶ���һ��
		try {
			if(rs.next()) {
				// ����bean
				Object bean = clazz.newInstance();
				// ��װ����
				// ��ý������Ԫ����
				ResultSetMetaData metaData = rs.getMetaData();
				int count = metaData.getColumnCount();
				// ����ȡÿһ�е�����
				for(int i=1; i<=count; i++) {
					// �������  username
					String columnName = metaData.getColumnName(i);
					// ������� ddd
					Object value = rs.getObject(columnName);
					// �������������ӳ������� username
					Field field = clazz.getDeclaredField(columnName);
					// Ϊ���Ը�ֵ
					field.setAccessible(true);
					field.set(bean, value);
				}
				return bean;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
