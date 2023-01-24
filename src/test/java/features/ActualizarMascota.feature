Feature: Pruebas del API PET STORE

  @smokeTest
  Scenario: Actualizar mascota registrada  en la tienda
    Given Validar el servicio de actualización de una mascota
      | body                   | exp | escenario          |
      | actualizarMascota.json | 200 | Actualizar Mascota |

    Then Obtener mascota actualizada de la tienda por medio de su id
      | exp | escenario           |
      | 200 | consulta de Mascota |
