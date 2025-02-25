using Microsoft.EntityFrameworkCore;
using ResiduosApi.Models;

public class ResiduosDbContext : DbContext
{
    // Constructor que recibe las opciones de configuración (conexión a la BD)
    public ResiduosDbContext(DbContextOptions<ResiduosDbContext> options)
        : base(options)
    { }

    // Propiedad que representa la tabla "Residuos" en la base de datos.
    // Cada entidad 'Residuo' se mapea a una fila en esta tabla.
    public DbSet<Residuo> Residuos { get; set; }
}