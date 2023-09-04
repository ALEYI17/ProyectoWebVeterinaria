
document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchInput");
    const clientTable = document.getElementById("clientTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr");

    searchInput.addEventListener("input", function () {
      const searchText = searchInput.value.toLowerCase();

      for (let i = 0; i < clientTable.length; i++) {
        const clientRow = clientTable[i];
        const clientName = clientRow.getElementsByTagName("th")[0].textContent.toLowerCase();

        if (clientName.includes(searchText)) {
          clientRow.style.display = "";
        } else {
          clientRow.style.display = "none";
        }
      }
    });
  });