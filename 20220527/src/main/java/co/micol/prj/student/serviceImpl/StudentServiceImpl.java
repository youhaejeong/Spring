package co.micol.prj.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;


@Repository("studentDao")
public class StudentServiceImpl implements StudentService {
	//컨테이너 안에 실려있는 데이터소스라는 객체를 내가 사용할수 있도록 자동으로 주입 
	//다음줄에만 영향을 미침 자동주입
	@Autowired
	private DataSource dataSource;  //Ioc 에 등록된 DBCP를 불러온다
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	

	@Override
	public List<StudentVO> studentSelectList() {
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO vo;
		String sql="SELECT * FROM STUDENT";
		try {
			conn =dataSource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo=new StudentVO(); //초기화
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setAge(rs.getInt("age"));
				students.add(vo);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int studentInsert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int studentDelete(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean studentIdCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
