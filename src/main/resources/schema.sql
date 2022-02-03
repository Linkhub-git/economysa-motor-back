create table oauth_access_token
(
    token_id varchar(256) null,
    token blob null,
    authentication_id varchar(256) not null
        primary key,
    user_name varchar(256) null,
    client_id varchar(256) null,
    authentication blob null,
    refresh_token varchar(256) null
);

create table oauth_refresh_token
(
    token_id varchar(256) null,
    token blob null,
    authentication blob null
);

create table USER
(
    id int(19) not null
        primary key,
    email varchar(50) not null,
    password varchar(256) not null,
    role varchar(10) not null,
    name varchar(100) not null,
    last_name varchar(100) not null,
    phone varchar(9) null,
    creation_date timestamp(6) null,
    status int(1) not null
);

create table VENDEDOR
(
    codigo varchar (10) not null
        primary key,
    nombres varchar(50) not null,
    telefono varchar(10) not null,
    correo varchar(20) not null,
    jvta varchar(10) not null,
    jefe_venta varchar(50) not null,
    cod_sup varchar(10) not null,
    supervisor varchar(20) not null
);

create table CLIENTE
(
    codigo varchar (10) not null
        primary key,
    nombre_cliente varchar(50) not null,
    codigo_padre varchar(10) null,
    razon_social varchar(20) null,
    tipo_doc varchar(10) not null,
    nro_doc varchar(10) not null,
    celular varchar(10) not null,
    correo varchar(30) not null,
    limite_cred decimal not null,
    limite_doc decimal not null,
    direccion_fiscal varchar(50) null,
    ubigeo varchar(50) not null,
    estado int(1) not null
);

create table DIRECCION_ENTREGA
(
    cod_direccion varchar (10) not null
        primary key,
    cod_cli varchar(10) not null,
    direccion_entrega varchar(50) not null,
    ruta varchar(20) not null,
    modulo varchar(10) not null,
    ubigeo varchar(50) not null,
    giro varchar(20) not null,
    latitud varchar(20) not null,
    longitud varchar(20) not null,
    secuencia_visita varchar(30) not null,
    horario_vent1 varchar(20) not null,
    horario_vent2 varchar(20) not null,
    estado int(1) not null
);

create table PRODUCTO
(
    id varchar (10) not null
        primary key,
    nombre varchar(50) not null,
    purchase_packaging varchar(20) not null,
    master_stock_amount decimal not null,
    sales_packaging decimal not null,
    stock_amount decimal not null,
    id_proveedor varchar(10) not null,
    stock decimal null,
    precio_base decimal null,
    margen decimal not null,
    precio_final decimal not null,
    denominacion_corta varchar(50) not null,
    unidad_venta varchar(20) not null,
    categoria varchar(20) not null,
    subcategoria varchar(20) not null,
    master varchar(20) not null,
    fecha_vencimiento date null,
    precio_venta decimal not null,
    precio_compra decimal not null,
    codigo_ean varchar(20) not null,
    peso decimal not null,
    dimension decimal not null,
    suspendido_compra int(1) not null,
    suspendido_venta int(1) not null,
    afecto int(1) not null,
    stock_actual decimal not null,
    stock_reserva decimal not null,
    codigo_origen_proveedor varchar(10) not null,
    codigo_sunat varchar(10) null,
    sucursal varchar(50) null,
    estado int(1) not null
);

create table PROMOCION
(
    id_mecanica varchar (10) not null
        primary key,
    id_proveedor varchar(10) not null,
    tipo_promocion int(11) not null,
    modalidad_promocion int(11) not null,
    unidad_promocion varchar(10) not null,
    factor decimal not null,
    dscto decimal not null,
    cantidad decimal not null,
    lista_precio varchar(20) not null,
    min decimal not null,
    max decimal not null,
    cantidad_max_bonif decimal not null,
    cant_max_pdv varchar(20) not null,
    fecha_ini date null,
    hora_ini varchar(20) not null,
    fecha_fin date null,
    hora_fin varchar(20) not null,
    tope decimal not null,
    observacion varchar(100) not null
);

create table PROVEEDOR
(
    id varchar (10) not null
        primary key,
    nombre varchar(50) not null,
    ruc varchar(20) not null
);