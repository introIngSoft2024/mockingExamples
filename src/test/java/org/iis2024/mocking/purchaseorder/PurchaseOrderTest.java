package org.iis2024.mocking.purchaseorder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PurchaseOrderTest {

  @Test
  void shouldPurchaseWorkProperlyWhenThereAreEnoughProducts() {
    // STEP 1: create mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class);

    // STEP 2: define behavior (stubbing)
    Mockito.when(warehouse.thereAreProducts("Milk", 20)).thenReturn(true);

    // STEP 3: execute
    PurchaseOrder purchaseOrder = new PurchaseOrder("Milk", 20);
    purchaseOrder.purchase(warehouse);

    // STEP 4: verify
    Mockito.verify(warehouse).remove("Milk", 20);
    Mockito.verify(warehouse, Mockito.times(1)).remove("Milk", 20);
  }

  @Test
  void shouldPurchaseWorkProperlyWhenThereAreNotEnoughProducts() {
    // STEP 1: create mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class);

    // STEP 2: define behavior
    Mockito.when(warehouse.thereAreProducts("Milk", 20)).thenReturn(false);

    // STEP 3: execute
    PurchaseOrder purchaseOrder = new PurchaseOrder("Milk", 20);
    purchaseOrder.purchase(warehouse);

    // STEP 4: verify
    Mockito.verify(warehouse, Mockito.never()).remove("Milk", 20);
  }
}
