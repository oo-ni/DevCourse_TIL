use workshop;
show tables;
select * from emp;

select empno, ename, sal from emp;

select ename, sal as '월급', sal*12 as '연봉' from emp;
select ename, sal as '월급', sal*12 as '연봉'
from emp
order by 월급 asc;

-- 연봉에 커미션까지 더해서 사번, 이름, 월급, 연봉, 연봉(커미션포함) 출력
select empno as '사번', ename as '이름', sal as '연봉', sal + COALESCE(comm, 0) as '커미션 포함' from emp;

-- 부서 번호가 10번인 직원 목록을 사번, 이름, 부서번호 출력
select empno as '사번', ename as '이름', deptno as '부서번호' from emp where deptno = 10;

-- 급여가 1000 이상 1500 이하인 직원목록 사번, 이름, 급여 출력 (and 조건 쓰기)
select empno as '사번', ename as '이름', sal as '급여' from emp where sal >= 1000 and sal <=1500;

-- 급여가 1000 이상 1500 이하인 직원목록 사번, 이름, 급여 출력 (between 조건 쓰기)
select empno as '사번', ename as '이름', sal as '급여' from emp where sal between 1000 and 1500;

-- 커미션 받는 직원이랑 안받는 직원 각각 사번, 이름, 커미션 출력
select empno as '사번', ename as '이름', comm as '커미션', if(comm is null, 'N', 'Y') as '커미션 여부' from emp;
select empno as '사번', ename as '이름', comm as '커미션' from emp where comm is not null;

-- 직원들이 속한 모든 부서번호만 출력하되 중복된 출력은 없게
select distinct deptno from emp;

-- 30번 부서에 속한 직원들의 급여를 내림차순으로 정렬하여 그 중 가장 많은 급여를 받는 상위 3명의 이름과 급여를 조회
select ename as '이름', sal as '급여' from emp where deptno = 30 order by sal desc limit 3;

select deptno, count(deptno) from emp group by deptno;

-- group by에서 조건 추출할 경우에는 having절을 활용
select deptno, sum(sal) from emp group by deptno having sum(sal) > 9000;
-- group by 전에 where로 미리 추출 후 group by 해줘도 됨
select deptno, sum(sal) from emp where sal > 1000 group by deptno;

create table book_tb(
                        bno int primary key auto_increment,
                        title varchar(30),
                        writer varchar(30),
                        price int,
                        publisher varchar(50)
);

insert into book_tb() values(1, 'java programming', 'geonoo', 50000, 'grepp');
insert into book_tb(title, writer, price, publisher) values
    ('java programming22', 'geonoo', 50000, 'grepp'),
    ('java programming33', 'geonoo', 50000, 'grepp'),
    ('java programming44', 'geonoo', 50000, 'grepp')
;	-- auto increment : 지정 칼럼 값을 생략하는 bno경우 자동증가로 들어감.

select * from book_tb;

delete from book_tb where bno=2;