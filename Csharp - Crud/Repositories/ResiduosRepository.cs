using Microsoft.EntityFrameworkCore;
using ResiduosApi.Models;

public class ResiduosRepository 
{
    // Variable privada de solo lectura para conexión a la BD
    private readonly ResiduosDbContext _context;

    // Inyección de dependencias (se pasa la instancia de ResiduosDbContext)
    public ResiduosRepository(ResiduosDbContext context)
    {
        _context = context;
    }

    // Método para traer todos los datos de la base de datos
    public async Task<IEnumerable<Residuo>> GetAllAsync()
    {
        return await _context.Residuos.ToListAsync();
    }

    // Método para obtener un residuo por su ID
    public async Task<Residuo?> GetByIdAsync(int id)
    {
        return await _context.Residuos.FindAsync(id);
    }

    // Método para agregar un nuevo residuo a la BD
    public async Task AddAsync(Residuo residuo)
    {
        await _context.Residuos.AddAsync(residuo);
        await _context.SaveChangesAsync();
    }

    // Método para actualizar un residuo existente en la BD
    public async Task UpdateAsync(Residuo residuo)
    {
        _context.Residuos.Update(residuo);
        await _context.SaveChangesAsync();
    }

    // Método para eliminar un residuo por su ID
    public async Task DeleteAsync(int id)
    {
        var residuo = await GetByIdAsync(id);
        if (residuo != null)
        {
            _context.Residuos.Remove(residuo);
            await _context.SaveChangesAsync();
        }
    }
}