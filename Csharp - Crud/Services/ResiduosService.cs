using ResiduosApi.Models;

public class ResiduosService
{
    // Variable privada de solo lectura para acceso al repositorio
    private readonly ResiduosRepository _repository;

    // Inyección de dependencias del repositorio en el servicio
    public ResiduosService(ResiduosRepository repository)
    {
        _repository = repository;
    }

    // Método para obtener todos los residuos
    public async Task<IEnumerable<Residuo>> ObtenerResiduosAsync()
    {
        return await _repository.GetAllAsync();
    }

    // Método para obtener un residuo por su ID
    public async Task<Residuo?> ObtenerResiduoPorIdAsync(int id)
    {
        return await _repository.GetByIdAsync(id);
    }

    // Método para agregar un nuevo residuo
    public async Task AgregarResiduoAsync(Residuo residuo)
    {
        await _repository.AddAsync(residuo);
    }

    // Método para actualizar un residuo existente
    public async Task ActualizarResiduoAsync(Residuo residuo)
    {
        await _repository.UpdateAsync(residuo);
    }

    // Método para eliminar un residuo por su ID
    public async Task EliminarResiduoAsync(int id)
    {
        await _repository.DeleteAsync(id);
    }
}
