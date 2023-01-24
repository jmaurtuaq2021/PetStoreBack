Feature: Pruebas del API PET STORE

  @smokeTest
  Scenario: Buscar mascota registrada  en la tienda
    Given Validar el servicio del registro de una mascota
      | body                | exp | escenario       |
      | agregarMascota.json | 200 | Agregar Mascota |
    Then Obtener mascota de la tienda por medio de su id
      | exp | escenario           |
      | 200 | consulta de Mascota |


  Scenario: Buscar mascota registrada  en la tienda
    Given Validar el servicio del registro de una mascota
      | body                | exp | escenario       |
      | agregarMascota.json | 200 | Agregar Mascota |

