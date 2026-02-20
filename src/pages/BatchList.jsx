import { useEffect, useState } from "react";
import API from "../api/Axoisinstance";

export default function BatchList() {
  const [batches, setBatches] = useState([]);

  useEffect(() => {
    API.get("/batch")
      .then(res => setBatches(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
      <h2>All Batches</h2>
      {batches.map(batch => (
        <div key={batch.id}>
          <p>{batch.name} - {batch.status}</p>
        </div>
      ))}
    </div>
  );
}