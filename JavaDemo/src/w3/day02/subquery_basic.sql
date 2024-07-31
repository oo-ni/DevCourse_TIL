-- 평균 급여보다 많은 급여를 받는 직원 조회
select avg(sal) from emp;	-- subquery

select * from emp
where sal > (select avg(sal) from emp);

-- 만약 서브쿼리의 실행 결과가 값 1개가 아니라 여러개의 행으로 나왔다면?
select avg(sal) from emp group by deptno;

select * from emp
where sal > (select avg(sal) from emp group by deptno);		-- 결과행이 3개인데 이중에 누구보다 큰애...? error!!

-- 서브쿼리 결과가 다중행이라서 그 중에 하나라도 일치 in, 또는 하나라도 더 작은(큰) any, 또는 전체 모두를 통틀어 보다 작은(큰) all
select * from emp
where sal > any (select avg(sal) from emp group by deptno);

select * from emp
where sal > all (select avg(sal) from emp group by deptno);

-- in은 서브쿼리 실행 결과가 여러 행일때 그 중 하나라도 일치하는게 있으면
select distinct mgr from emp where mgr is not null;		-- 일단 누군가의 상사들을 모아서 봤더니 6명의 번호가 나오네?

select ename, empno from emp
where empno in (select distinct mgr from emp where mgr is not null);

-- 서브쿼리 실행 결과가 다중 열...(잘 안쓰긴 함)인 경우에는?
select job, deptno from emp where ename='ALLEN';

select * from emp
where (job, deptno) in (select job, deptno from emp where ename='ALLEN');

-- ALLEN이 SALESMAN이고 30번 부서 소속이었음. 그런 애들 찾아내기.
select * from emp
where (job, deptno) in (select job, deptno from emp where ename like 'A%');

-- select ~~ from (이자이레 서브쿼리 오는 경우?! 원래 테이블 이름 와야하는 자리인데??) : 인라인뷰
-- 20번 부서 사람 중 커미션 받는 애 연봉 얼마? where deptno=20 and comm in not null 이렇게 조건 줘도 되지만 굳이 서브쿼리를 써보자면
select * from emp where deptno = 20;	-- 일단 20번 부서 사람만 추려내고
select ename, sal * 12 + comm
from (select * from emp where deptno = 20) tmp
where comm is not null;
-- !!! 이렇게 from에 사용되는 테이블인 척하는 서브쿼리는 alias 필수로 붙여줘야함!

-- 20번 부서인 애들 이름, 사번, 급여, 부서이름
select empno, ename, sal, emp.deptno, dname
from emp join dept
              on emp.deptno = dept.deptno
where dept.deptno=20;

select avg(sal) from emp;	-- 2073.2143$

select * from (
    select empno, ename, sal, emp.deptno, dname
    from emp join dept
        on emp.deptno = dept.deptno where dept.deptno=20) tmp	-- 20번 부서 소속 애들만 대상으로 조회한 다음
where tmp.sal > (select avg(sal) from emp);	-- 전체 급여 평균보다 많이 받는 직원 조회

-- select (이자리에 서브쿼리. 원래 컬럼이름 오는 자리임.) from ~~ : scalar subquery - 궁금하면 찾아보기. 잘 쓰진 않음.
-- ------------------------------------------------------------------------------------------------
-- create, insert, update, delete에 서브쿼리 활용되는 경우
drop table if exists emp_blank;
create table emp_blank
select * from emp;		-- select 서브쿼리 결과로 그대로 테이블 만드니까 데이터까지 복사

create table emp_blank
select * from emp where 1 = 0;	-- select 결과에 레코드는 없어서 테이블 구조만 복사

insert into emp_blank
select * from emp where deptno = 20;	-- 20번 부서인 애들만 골라서 insert 시키기

-- update나 delete는 그냥 select의 where 조건에서 쓰던거랑 비슷!