$(document).ready(function() {
    // Function to format the date
    function formatDate(date) {
        const options = {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        };
        return date.toLocaleString('en-US', options);
    }

    // Get the current date
    const currentDate = new Date();

    // Format the date
    const formattedDate = formatDate(currentDate);

    // Display the formatted date in the HTML element
    $('#currentDate').text(formattedDate);
});
//-----------------------------Navigation--------------------------------

const nicPattern = /^\d{9}[VvXx]$/;
const regNIC = new RegExp(nicPattern);
