@E2EAPI
Feature: CRUD commands

  @addPet
  Scenario: Verification of new addition of a Pet

    Given user adds a new pet to the store


  @updatePet
  Scenario: Verification of updating an existing Pet

    Given user updates a existing pet

  @getPetByStatus
  Scenario: Verification of getting the pets by status

    Given user fetches the pets by available status

  @deletePet
  Scenario: Verification of deleting the pets by id

    Given user deletes the pets by id 2498