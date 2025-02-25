// Definicion de controlador
using Microsoft.AspNetCore.Mvc;
using ResiduosApi.Models;

[ApiController]
// Definir la ruta de el controlador
[Route("api/[controller]")]
public class ResiduosController : ControllerBase
{
    // Variable privada de solo lectura para el servicio
    private readonly ResiduosService _service;

    // Inyección de dependencias del servicio en el controlador
    public ResiduosController(ResiduosService service)
    {
        _service = service;
    }

    // Endpoint GET: Obtener todos los residuos
    [HttpGet]
    public async Task<IActionResult> GetAll()
    {
        var residuos = await _service.ObtenerResiduosAsync();
        return Ok(residuos);
    }

    // Endpoint GET: Obtener un residuo por ID
    [HttpGet("{id}")]
    public async Task<IActionResult> GetById(int id)
    {
        var residuo = await _service.ObtenerResiduoPorIdAsync(id);
        if (residuo == null) return NotFound();
        return Ok(residuo);
    }

    // Endpoint POST: Agregar un residuo nuevo
    [HttpPost]
    public async Task<IActionResult> Create([FromBody] Residuo residuo)
    {
        if (residuo == null) return BadRequest();
        await _service.AgregarResiduoAsync(residuo);
        return CreatedAtAction(nameof(GetById), new { id = residuo.Id }, residuo);
    }

    // Endpoint PUT: Actualizar un residuo
    [HttpPut("{id}")]
    public async Task<IActionResult> Update(int id, [FromBody] Residuo residuo)
    {
        if (id != residuo.Id) return BadRequest();
        await _service.ActualizarResiduoAsync(residuo);
        return NoContent();
    }

    // Endpoint DELETE: Eliminar un residuo
    [HttpDelete("{id}")]
    public async Task<IActionResult> Delete(int id)
    {
        await _service.EliminarResiduoAsync(id);
        return NoContent();
    }
}