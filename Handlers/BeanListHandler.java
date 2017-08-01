	public class BeanListHandler implements ResultSetHandler {

	private Class clazz;
	public BeanListHandler(Class clazz) {
		this.clazz = clazz;
	}
	public Object handle(ResultSet rs) {
		try {
			// ȡ����������еļ�¼����װ��bean������list����
			List list = new ArrayList();
			while (rs.next()) {
				Object bean = clazz.newInstance();
				// ���Ԫ����
				ResultSetMetaData metaData = rs.getMetaData();
				// ����е�����
				int count = metaData.getColumnCount();
				// ������
				for(int i=1; i<=count; i++) {
					// ȡ����
					String columnName = metaData.getColumnName(i);
					// ȡ���е�ֵ
					Object value = rs.getObject(columnName);
					// ���������
					Field field = clazz.getDeclaredField(columnName);
					// ��������
					field.setAccessible(true);
					field.set(bean, value);
				}
				// ����list
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
