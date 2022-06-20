$(document).ready(function () {
    listarSucursal();
    listarClientes();
    listarUsuarios();
    listarProducto();
    //capturarProducto();
});

var productos = [];

function listarSucursal() {
    $.get("sc", {opcion: 1}, function (data) {

        let x = JSON.parse(data);
        //console.table(data);
        for (let i = 0; i < x.length; i++) {
            $("#sucursal").append("<option value='" + x[i].idsucursal + "'>" + x[i].nombre + "</option>")
        }
    }
    );
}
function listarClientes() {
    $.get("cc", {opcion: 1}, function (data) {

        let x = JSON.parse(data);
        //console.table(data);
        for (let i = 0; i < x.length; i++) {
            $("#cliente").append("<option value='" + x[i].idclientes + "'>" + x[i].Apellidos + "</option>")

        }
    }
    );
}

function listarUsuarios() {
    $.get("uc", {opcion: 1}, function (data) {
        let x = JSON.parse(data);
        //console.table(data);
        for (let i = 0; i < x.length; i++) {
            $("#vendedor").append("<option value='" + x[i].idusuario + "'>" + x[i].Apellidos + "</option>")
        }
    }
    );
}

function listarProducto() {

    $.get("pc", {opcion: 1}, function (data) {

        let x = JSON.parse(data);
        //console.table(data);
        for (let i = 0; i < x.length; i++) {
            $("#producto").append("<option value='" + x[i].idproducto + "'>" + x[i].nombre + "</option>")
        }
    }
    );
}
function capturarProducto() {
    // capturando valores del prodcuto
    const idProducto = Number($('#producto').val());
    //console.log('valorsi trajo', { idProducto });
    
    // buscando el producto
    const productoEncontrado = productos.find((producto) => producto.idproducto === idProducto);
    //console.log({ productoEncontrado });
    
    // mostrando el  producto
    $("#produc").val(productoEncontrado.nombre);
    $("#precio").val(productoEncontrado.precio);
    $("#stock").val(productoEncontrado.stock);
    $("#txtIdProductoHide").val(productoEncontrado.idproducto);

}
