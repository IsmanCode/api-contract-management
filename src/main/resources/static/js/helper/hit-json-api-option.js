function hitJsonApiOption (request) {
    request.firstElement.addEventListener('change', function() {
        const selectedId = this.value;

        fetch(request.url+`/${selectedId}`) // Endpoint untuk data kedua
            .then(response => response.json())
            .then(data => {
                request.secondElement.innerHTML = '<option value="">Select an option</option>';
                request.secondElement.disabled = !selectedId;

                data.data.forEach(item => {
                    const option = document.createElement('option');
                    option.value = item.id;
                    option.textContent = item.name;
                    request.secondElement.appendChild(option);
                });
            });
    });
}