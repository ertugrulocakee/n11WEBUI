Feature: n11.com
  Scenario: randomly select a shop
    Given User is on homepage
    When Click accept cookies
    When Click the brands button
    When Filter for Character
    When Click Brand

  Scenario: n11.com Adding Product
    Given User is on homepage
    When Click accept cookies
    When Write product name "iPhone"
    When Add to Cart

  Scenario: n11.com List Products
    Given User is on homepage
    When Click accept cookies
    When Write product name "telefon"
    When Select second phone
    When Filter for Comments
