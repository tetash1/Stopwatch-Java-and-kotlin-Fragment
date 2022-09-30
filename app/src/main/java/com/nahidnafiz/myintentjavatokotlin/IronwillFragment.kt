package com.nahidnafiz.myintentjavatokotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nahidnafiz.myintentjavatokotlin.databinding.FragmentIronwillBinding
import java.util.*


class IronwillFragment : Fragment() {

   // val arr = ArrayList<Int>()
    private lateinit var binding:FragmentIronwillBinding

    private var dataHelper:DataHelper?=null
    //private var dataHelperint:DataHelper?=null
    private var applicationContext: Context?=null
    private val timer = Timer()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        //from
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
       // val view: View= inflater.inflate(R.layout.fragment_ironwill, container, false)
        binding = FragmentIronwillBinding.inflate(inflater,container,false)
        //dataHelper = DataHelper(applicationContext)
        applicationContext = requireContext()

        dataHelper=DataHelper(requireContext())





        if (dataHelper!!.timerCounting()) {
                startTimer()
            } else {
                stopTimer()
                if (dataHelper!!.startTime() != null && dataHelper!!.stopTime() != null) {
                    val time = Date().time - calcRestartTime().time
                    binding.timeTV.text = timeStringFromLong(time)
                }
            }

            timer.scheduleAtFixedRate(TimeTask(), 0, 500)


        return binding.root



    }// end of oncrete like Java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val carssor = AnimationUtils.loadAnimation(context,R.anim.rounding_carsor)
       //   binding.carsorid.startAnimation(carssor)




        //  binding.addvaluetoaarry.setOnClickListener{

     //       arr.add(100)
     //       arr.add(200)
       //     arr.add(2)
       // }




        binding.startButton.setOnClickListener{ startStopAction()
          //  binding.carsorid.startAnimation(carssor)


        }
        binding.resetButton.setOnClickListener{ resetAction()


        }

     //   binding.carsorid.startAnimation(carssor)


      //  val builder = StringBuilder()

       // for (i in arr) {
     //       builder.append("$i ")
     //   }
      //  Toast.makeText(context, builder, Toast.LENGTH_LONG).show()


    }

        //methods
    private inner class TimeTask: TimerTask()
    {
        override fun run()
        {
            if(dataHelper!!.timerCounting())
            {
                val time = Date().time - dataHelper!!.startTime()!!.time
                binding.timeTV.text = timeStringFromLong(time)
            }
        }
    }

    private fun resetAction()
    {
        dataHelper?.setStopTime(null)
        dataHelper?.setStartTime(null)
        stopTimer()
        binding.timeTV.text = timeStringFromLong(0)
    }

    private fun stopTimer()
    {
        dataHelper?.setTimerCounting(false)
        binding.startButton.text = getString(R.string.start)
    }

    private fun startTimer()
    {
        dataHelper?.setTimerCounting(true)
        binding.startButton.text = getString(R.string.stop)
    }

    private fun startStopAction()
    {
        if(dataHelper?.timerCounting() == true)
        {
            dataHelper?.setStopTime(Date())
            stopTimer()
        }
        else
        {
            if(dataHelper?.stopTime() != null)
            {
                dataHelper?.setStartTime(calcRestartTime())
                dataHelper?.setStopTime(null)
            }
            else
            {
                dataHelper?.setStartTime(Date())
            }
            startTimer()
        }

    }

    private fun calcRestartTime(): Date
    {
        val diff = dataHelper?.startTime()!!.time - dataHelper?.stopTime()!!.time
        return Date(System.currentTimeMillis() + diff)
    }

    private fun timeStringFromLong(ms: Long): String
    {
        val seconds = (ms / 1000) % 60
        val minutes = (ms / (1000 * 60) % 60)
        val hours = (ms / (1000 * 60 * 60) % 24)
        val days = (ms / (1000 * 60 * 60 * 24))

      //  arr.add(days.toInt())





        if (days>1){
            binding.showdays.text = days.toString()+"Days"
        }else{
            binding.showdays.text = days.toString()+"Day"
        }

        return makeTimeString(days, hours, minutes, seconds)
    }

    private fun makeTimeString(day: Long,hours:Long, minutes: Long, seconds: Long): String
    {
        return String.format("%02d:%02d:%02d:%02d",day, hours, minutes, seconds)
    }





    }



