insert into propietarios_mascotas (nmid, dsnombre_completo, dstipo_documento, nmidentificacion, dsciudad, dsdireccion, nmtelefono, dtfecha_registro)
values (1,"Javier Hernandez","C.C",1525455263,"Medellín","Calle 97B #25-32",23371537,"2023/09/15");

insert into especie_mascotas (nmid,dsespecie)
values (1,"Gato"),
       (2,"Loro"),
       (3,"Perro"),
       (4,"Tortuga");

insert into mascotas (nmid,dsnombre_mascota,dsraza,dtfecha_nacimiento,nmid_propietarios,nmid_especie)
values (1,"Lupita","Doberman","2022/05/12",1,3);

insert into usuarios (nmid,dsnombrecompleto,dscorreo,dsusuario,dsrol,password)
values (1,"Sebastian","sebas@gmail.com","Sebas","Admin","123456"),
       (2,"Paula","pau123@gmail.com","Paula","Empleado","12345");
