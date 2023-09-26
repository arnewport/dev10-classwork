export default function Numbers({ value, min, max }) {
    if (value >= min && value <= max) {
        return (
            <li>{value}</li>
        );
    }
}
