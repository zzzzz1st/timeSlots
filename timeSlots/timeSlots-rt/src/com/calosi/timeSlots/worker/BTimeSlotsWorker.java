package com.calosi.timeSlots.worker;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.NotRunningException;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BWorker;
import javax.baja.util.CoalesceQueue;
import javax.baja.util.Worker;

/**
 * Created by R. Derek Otieno on October 10, 2019
 */
@NiagaraProperty(name = "queueSize", type = "int", defaultValue = "1000")
@NiagaraType
public class BTimeSlotsWorker extends BWorker
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.calosi.timeSlots.worker.BTimeSlotsWorker(309397979)1.0$ @*/
/* Generated Tue Jul 27 12:22:13 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "queueSize"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code queueSize} property.
   * @see #getQueueSize
   * @see #setQueueSize
   */
  public static final Property queueSize = newProperty(0, 1000, null);
  
  /**
   * Get the {@code queueSize} property.
   * @see #queueSize
   */
  public int getQueueSize() { return getInt(queueSize); }
  
  /**
   * Set the {@code queueSize} property.
   * @see #queueSize
   */
  public void setQueueSize(int v) { setInt(queueSize, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTimeSlotsWorker.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public Worker getWorker()
    {
        if (worker == null)
        {
            queue = new CoalesceQueue(getQueueSize());
            worker = new Worker(queue);
        }
        return worker;
    }

    /**
     * Post an action to be run asynchronously.
     */
    public void postAsync(Runnable r)
    {
        if (!isRunning() || queue == null)
            throw new NotRunningException();
        queue.enqueue(r);
    }

    //////////////////////////////////////////////////////////
    //  Attributes
    //////////////////////////////////////////////////////////
    private CoalesceQueue queue;
    private Worker worker;
}