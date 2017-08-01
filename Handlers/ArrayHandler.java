// ȡ����һ�е����м�¼����һ��Object����
public class ArrayHandler implements ResultSetHandler {

	public Object handle(ResultSet rs) {
		try {
			if (rs.next()) {
				// ָ���˵�һ�еļ�¼
				// ���Ԫ����
				ResultSetMetaData metaData = rs.getMetaData();
				// �������
				int count = metaData.getColumnCount();
				// ��������
				Object[] arr = new Object[count];
				// ���������е�ֵ����������
				for(int i=1; i<=count; i++) {
					Object value = rs.getObject(i);	// ���ָ���е�ֵ
					arr[i-1] = value;
				}
				return arr;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
