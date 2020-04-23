package jp.mufg.it.mybatis.company.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.EmpDept;
import jp.mufg.it.mybatis.company.mapper.EmpDeptFlatMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * ジョインしてフラットオブジェクトを取得する
 */
public class FlatSelectMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmpDeptFlatMapper mapper = sqlSession.getMapper(EmpDeptFlatMapper.class);

        // SELECT文を発行し結果を表示する
        List<EmpDept> resultList = mapper.selectEmpDeptByDepartmentId(3);
        ResultUtil.showEmpDeptList(resultList);
    }
}