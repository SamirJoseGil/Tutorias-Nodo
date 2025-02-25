using Microsoft.EntityFrameworkCore;


// Crea el constructor de la aplicación con la configuración inicial

var builder = WebApplication.CreateBuilder(args);

// Agrega los controladores al contenedor de servicios
builder.Services.AddControllers();
// ...

// Agrega soporte para endpoints y exploración de la API
builder.Services.AddEndpointsApiExplorer();

// Configuración de Swagger para documentar la API
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new() { Title = "ResiduosApi", Version = "v1" });
});

// Configura la conexión a la base de datos usando PostgreSQL
builder.Services.AddDbContext<ResiduosDbContext>(options =>
{
options.UseNpgsql(builder.Configuration.GetConnectionString("ResiduosDBPSQL"));
});

// Agrega el repositorio al contenedor de dependencias
builder.Services.AddScoped<ResiduosRepository>();
// ...

// Agrega los servicios necesarios al contenedor de dependencias
builder.Services.AddScoped<ResiduosService>();
// ...

// Construye la aplicación con todas las configuraciones anteriores
var app = builder.Build();

// Configura el pipeline de peticiones HTTP
if (app.Environment.IsDevelopment())
{
    // En desarrollo, activa Swagger para poder probar la API visualmente
    app.UseSwagger();
    app.UseSwaggerUI();
}

// Habilita el enrutamiento para la aplicación
app.UseRouting();

// Mapea los controladores para que respondan a las rutas definidas
app.MapControllers();

// Inicia la aplicación y empieza a escuchar peticiones HTTP
app.Run();
