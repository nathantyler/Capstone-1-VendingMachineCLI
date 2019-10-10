Project Progress Trello Board: https://trello.com/b/op2jHF4y/vending-machine

- 1. User Stories (MVP): 
    - Vendor: 
      - As a vendor, I want to be able to build or update the inventory for the machine so that customers can get the items they want in most cases.
      - As a vendor, I want to be able to print audit file so that I can track the revenue and popular items.
    - Customer:
      - As a customer, I want to be able to purchase a certain item in the vending machine with certain cash values.
      - As a customer, I want to be able to get change or my money back if there is insufficient or unmatched funds.

- 2. Vending Machine Functions:
    - Vending Machine should be able to store a inventory of items (reading the log file).
    - Vending Machine should only store a certain quantity of items.
    - Vending Machine should assign each item a unique location.
    - Vending Machine should be able to display all items available to the customer.
    - Vending Machine should allow customer to select an item at a specific location.
    - Vending Machine should be able to update the number of a certain items in its inventory (writing to log file).
    - Vending Machine should be able to empty or refill the location where the item was stored.
    - Vending Machine should only accept certain cash values.
    - Vending Machine should be able to collect the cash given by a customer if it can give change  to the customer.
    - Vending Machine should print the change amount given to the customer.   
    - Vending Machine should store the total amount of change and different change values (writing  to log file).
    - Vending Machine should track the total amount of sales and revenue (writing to log file).
    - Vending Machine should be able to print the audit file (printing inventory and revenue).
    - Vending Machine should be able to handle all kinds of exceptions:
      - SoldOut Exception
      - StorageFull Exception
      - CashValue Exception