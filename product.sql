产品信息表
产品编号	proId
产品名称	proName
产品类别	proType
产品描述	proRemark

产品类别表
类别编号	typeId
类别名称	typeName

<!--修改产品 -->
	<update id="updateProduct" parameterType="Product">
		update LogAct
		<trim prefix="set" suffixOverrides=",">
			<if test="logTitle!=null">logTitle=#{logTitle},</if>
			<if test="logContent!=null">logContent=#{logContent},</if>
			<if test="logcreateTime!=null">logcreateTime=#{logcreateTime},</if>
		</trim>
		WHERE logId=#{logId}
		</update>
		<!-- 删除产品 -->
		<delete id="deleteSay" parameterType="String">
			delete Say,Activitys,SayPhoto from Say inner join Activitys ON
			Say.sayid=Activitys.sayid inner join SayPhoto on
			Say.sayid=SayPhoto.sayid WHERE Say.sayid=#{sayid}

		</delete>


use yswknight;
#产品信息表
create table productInfo(
proId int primary key auto_increment,			#产品编号
proName VARCHAR(20),											#产品名称
proType int,															#产品类别
proRemark VARCHAR(50)											#产品描述
);
select * from productInfo;

#产品类别表
create table productType(
typeId int primary key auto_increment,			#类别编号
typeName VARCHAR(20)												#类别名称
);
select * from productType;
#添加数据
insert into productType VALUES(1,'手机');
insert into productType VALUES(2,'电脑');
#
insert into productinfo values(1001,'meizuPRO6',1,'魅族旗舰机，值得拥有');
insert into productinfo values(1002,'ThinkPad E470',2,'办公神器，让你轻松自如');