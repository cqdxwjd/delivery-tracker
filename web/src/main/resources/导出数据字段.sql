SELECT p.`表英文名`,
       p.`表中文名`,
       p.`字段序号`,
       p.`字段英文名`,
       p.`字段中文名`,
       p.`字段类型`,
       p.`字段描述`,
       p.`是否分区字段`
FROM (
         SELECT s.name_cn '表中文名', @r :=
	CASE

			WHEN @name_en = s.name_en THEN
			@r + 1 ELSE 1
		END '字段序号',
	@name_en := s.name_en '表英文名',
	s.column_name '字段英文名',
	s.column_cn '字段中文名',
	s.column_type '字段类型',
	s.column_description '字段描述',
	s.partition_column '是否分区字段'
         FROM
             (
             SELECT
             a.name_en name_en,
             a.name_cn name_cn,
             b.column_name column_name,
             b.column_name column_cn,
             b.column_type column_type,
             b.column_description column_description,
             b.partition_column partition_column
             FROM
             data_resources a
             LEFT JOIN data_resource_columns b ON a.id = b.resource_id
             ORDER BY
             a.name_en,
             b.id
             ) s,
             ( SELECT @r := 0, @name_en := '' ) t
     ) p