��Ʒ��Ϣ��
��Ʒ���	proId
��Ʒ����	proName
��Ʒ���	proType
��Ʒ����	proRemark

��Ʒ����
�����	typeId
�������	typeName

<!--�޸Ĳ�Ʒ -->
	<update id="updateProduct" parameterType="Product">
		update LogAct
		<trim prefix="set" suffixOverrides=",">
			<if test="logTitle!=null">logTitle=#{logTitle},</if>
			<if test="logContent!=null">logContent=#{logContent},</if>
			<if test="logcreateTime!=null">logcreateTime=#{logcreateTime},</if>
		</trim>
		WHERE logId=#{logId}
		</update>
		<!-- ɾ����Ʒ -->
		<delete id="deleteSay" parameterType="String">
			delete Say,Activitys,SayPhoto from Say inner join Activitys ON
			Say.sayid=Activitys.sayid inner join SayPhoto on
			Say.sayid=SayPhoto.sayid WHERE Say.sayid=#{sayid}

		</delete>


use yswknight;
#��Ʒ��Ϣ��
create table productInfo(
proId int primary key auto_increment,			#��Ʒ���
proName VARCHAR(20),											#��Ʒ����
proType int,															#��Ʒ���
proRemark VARCHAR(50)											#��Ʒ����
);
select * from productInfo;

#��Ʒ����
create table productType(
typeId int primary key auto_increment,			#�����
typeName VARCHAR(20)												#�������
);
select * from productType;
#�������
insert into productType VALUES(1,'�ֻ�');
insert into productType VALUES(2,'����');
#
insert into productinfo values(1001,'meizuPRO6',1,'�����콢����ֵ��ӵ��');
insert into productinfo values(1002,'ThinkPad E470',2,'�칫������������������');