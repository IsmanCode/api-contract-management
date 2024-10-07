function hitJsonApi (data) {
    return Swal.fire({
        title: data.title,
        showCancelButton: true,
        confirmButtonText: "Confirm",
        showLoaderOnConfirm: true,
        preConfirm: async () => {
            try {
                const myHeaders = new Headers();
                myHeaders.append("Content-Type", "application/json");
                const response = await fetch(data.urlApi, {
                    method: data.method,
                    body: data.body,
                    headers: myHeaders,
                });
                return response;
            } catch (error) {
                Swal.showValidationMessage(`
                                    Request failed: ${error}
                                  `);
            }
        },
        allowOutsideClick: () => !Swal.isLoading()
    });
}