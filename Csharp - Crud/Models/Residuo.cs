// El namespace es una caja donde organizamos nuestras clases
namespace ResiduosApi.Models;


// public es para indicar que cualquier puede acceder a este dato
// class es para definir la plantilla para crear los objetos
public class Residuo     
{         
	public int Id { get; set; }
	// tipos de datos ( int ) tipo de dato numerico

	public string Nombre { get; set; } = string.Empty;
	// get y set permiten obtener y setear el valor de la propiedad

	public string Descripcion { get; set; } = string.Empty;
}
