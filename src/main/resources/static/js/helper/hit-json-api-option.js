function hitJsonApiDependOption (request) {
    let paramPath = '';
    if (request.id) {
        paramPath = `/${request.id}`;
    }
    fetch(request.url+paramPath) // Endpoint untuk data kedua
            .then(response => response.json())
            .then(data => {
                request.element.innerHTML = '<option value="">Select an option</option>';
                request.element.disabled = !selectedId;

                data.data.forEach(item => {
                    const option = document.createElement('option');
                    option.value = item.id;
                    option.textContent = item.name;
                    request.element.appendChild(option);
                });
            });
}