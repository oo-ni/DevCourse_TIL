-- 07/30 Mon --
use workshop;

select * from emp;
select * from dept;

select * from emp, dept;

-- join 전용 문법 없이 where 가지고 두 테이블의 레토드 연결하기
select * from emp, dept
where emp.deptno = dept.deptno;

-- 적어도 join 조건은 좀 where 말고 다른데 분리하자 (join 조건은 on에 기재하고 inner는 생략 가능)
select * from emp join dept
    on emp.deptno = dept.deptno
where sal > 1000;

-- 내가 원하는 컬럼을 지정할 때 어느 테이블 컬럼인지 적으려면 빡셈... 조인할때는 alias 붙임
select emp.ename, emp.empno, dept.dname
from emp join dept
    on emp.deptno = dept.deptno
where sal > 1000;

-- 테이블에 별칭 붙여서 좀 짧게 적으려고 함
select e.ename, e.empno, d.dname
from emp e join dept d
    on e.deptno = d.deptno
where sal > 1000;

-- 조인하려는 양쪽 테이블에 동일한 이름의 컬럼이 있고, 그 컬럼값 기준으로 같은거 조인할 때
select e.ename, e.empno, d.dname
from emp e join dept d
    using(deptno);

-- 컬럼명을 기재하는 것조차 귀찮아. but 양쪽 테이블에 컬럼명 같은게 한 쌍이어야 되겠지.. 제한적 사용
select e.ename, e.empno, d.dname
from emp e natural join dept d;

-- emp 테이블에 mgr 컬럼에 상사 직원번호가 있더라. 그 상사가 누군지 조회해서 같이 보자
select e.ename, e.empno, e.mgr, m.ename
from emp e join emp m
    on e.mgr = m.empno;		-- 직원의 매니저 번호를 직원번호 가지고 있는 내 상사를 조회하기로 함.

-- mgr이 null값인 직원은 빼고 13개의 컬럼만 조회해. null도 포함해서 모두의 join 결과를 조회할 수는 없을까? -> left join
select e.ename, e.empno, e.mgr, m.ename
from emp e left outer join emp m
    on e.mgr = m.empno;