package city_square;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import com.anylogic.libraries.road.*;
import com.anylogic.libraries.processmodeling.*;
import com.anylogic.libraries.modules.markup_descriptors.*;

import java.awt.geom.Arc2D;

public class Main extends Agent
{
  // Parameters
  // Plain Variables

  private 
int 
 carStopsCounter;
  public 
Vehicle 
 selectedCar;
  public 
ViewArea 
 selectedViewArea;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 4.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot1_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot2_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot3_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _plot_autoUpdateEvent_xjal ) return "plot auto update event";
     if( _e == _plot1_autoUpdateEvent_xjal ) return "plot1 auto update event";
     if( _e == _plot2_autoUpdateEvent_xjal ) return "plot2 auto update event";
     if( _e == _plot3_autoUpdateEvent_xjal ) return "plot3 auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot1_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot2_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot3_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if ( _e == _plot1_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if ( _e == _plot2_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if ( _e == _plot3_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == _plot_autoUpdateEvent_xjal) {
      _t = 
15 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if( _e == _plot1_autoUpdateEvent_xjal) {
      _t = 
15 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if( _e == _plot2_autoUpdateEvent_xjal) {
      _t = 
15 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if( _e == _plot3_autoUpdateEvent_xjal) {
      _t = 
15 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      plot.updateData();
      return;
    }
    if ( _e == _plot1_autoUpdateEvent_xjal ) {
      plot1.updateData();
      return;
    }
    if ( _e == _plot2_autoUpdateEvent_xjal ) {
      plot2.updateData();
      return;
    }
    if ( _e == _plot3_autoUpdateEvent_xjal ) {
      plot3.updateData();
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _carDispose_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _roadNetworkDescriptor_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public com.anylogic.libraries.road.CarSource<
Car 
> carSourceNorthCentral;
  public com.anylogic.libraries.road.CarMoveTo<
Vehicle 
> carMoveToNorthWest;
  public com.anylogic.libraries.road.CarDispose<
Vehicle 
> carDispose;
  public com.anylogic.libraries.road.CarMoveTo<
Vehicle 
> carMoveToSouthWest;
  public com.anylogic.libraries.road.CarSource<
Car 
> carSourceNorthWest;
  public com.anylogic.libraries.road.CarMoveTo<
Vehicle 
> carMoveToSouthEast1;
  public com.anylogic.libraries.road.CarSource<
Car 
> carSourceSouthEast;
  public com.anylogic.libraries.road.CarMoveTo<
Car 
> carMoveToNorthEast;
  public com.anylogic.libraries.road.CarSource<
Car 
> carSourceSouthWest;
  public com.anylogic.libraries.road.CarMoveTo<
Car 
> carMoveToNorthCenter;
  public com.anylogic.libraries.processmodeling.SelectOutput5<
Vehicle 
> selectOutput7;
  public com.anylogic.libraries.road.CarSource<
Car 
> carSourceNorthEast;
  public com.anylogic.libraries.processmodeling.SelectOutput<
Car 
> selectOutput;
  public com.anylogic.libraries.road.RoadNetworkDescriptor<
Vehicle 
> roadNetworkDescriptor;
  public com.anylogic.libraries.road.CarSource<
Bus 
> busSourceNorthEast;
  public com.anylogic.libraries.road.CarDispose<
Vehicle 
> carWayNotFoundDispose;
  public com.anylogic.libraries.processmodeling.SelectOutput<
Car 
> selectOutput2;
  public com.anylogic.libraries.road.CarSource<
Truck 
> truckSourceNorthEast;
  public com.anylogic.libraries.road.CarSource<
Bus 
> truckSourceNorthWest;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine9_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine8_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine2_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine5_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine4_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine3_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine6_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine7_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine1_controller_xjal;
  public com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<
Agent 
> _stopLine10_controller_xjal;

  public String getNameOf( Agent ao ) {
    if ( ao == carSourceNorthCentral ) return "carSourceNorthCentral";
    if ( ao == carMoveToNorthWest ) return "carMoveToNorthWest";
    if ( ao == carDispose ) return "carDispose";
    if ( ao == carMoveToSouthWest ) return "carMoveToSouthWest";
    if ( ao == carSourceNorthWest ) return "carSourceNorthWest";
    if ( ao == carMoveToSouthEast1 ) return "carMoveToSouthEast1";
    if ( ao == carSourceSouthEast ) return "carSourceSouthEast";
    if ( ao == carMoveToNorthEast ) return "carMoveToNorthEast";
    if ( ao == carSourceSouthWest ) return "carSourceSouthWest";
    if ( ao == carMoveToNorthCenter ) return "carMoveToNorthCenter";
    if ( ao == selectOutput7 ) return "selectOutput7";
    if ( ao == carSourceNorthEast ) return "carSourceNorthEast";
    if ( ao == selectOutput ) return "selectOutput";
    if ( ao == roadNetworkDescriptor ) return "roadNetworkDescriptor";
    if ( ao == busSourceNorthEast ) return "busSourceNorthEast";
    if ( ao == carWayNotFoundDispose ) return "carWayNotFoundDispose";
    if ( ao == selectOutput2 ) return "selectOutput2";
    if ( ao == truckSourceNorthEast ) return "truckSourceNorthEast";
    if ( ao == truckSourceNorthWest ) return "truckSourceNorthWest";
    if ( ao == _stopLine9_controller_xjal ) return "_stopLine9_controller_xjal";
    if ( ao == _stopLine8_controller_xjal ) return "_stopLine8_controller_xjal";
    if ( ao == _stopLine2_controller_xjal ) return "_stopLine2_controller_xjal";
    if ( ao == _stopLine5_controller_xjal ) return "_stopLine5_controller_xjal";
    if ( ao == _stopLine4_controller_xjal ) return "_stopLine4_controller_xjal";
    if ( ao == _stopLine3_controller_xjal ) return "_stopLine3_controller_xjal";
    if ( ao == _stopLine6_controller_xjal ) return "_stopLine6_controller_xjal";
    if ( ao == _stopLine7_controller_xjal ) return "_stopLine7_controller_xjal";
    if ( ao == _stopLine_controller_xjal ) return "_stopLine_controller_xjal";
    if ( ao == _stopLine1_controller_xjal ) return "_stopLine1_controller_xjal";
    if ( ao == _stopLine10_controller_xjal ) return "_stopLine10_controller_xjal";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Car> instantiate_carSourceNorthCentral_xjal() {
    com.anylogic.libraries.road.CarSource<Car> _result_xjal = new com.anylogic.libraries.road.CarSource<Car>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Car car ) {
        return _carSourceNorthCentral_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _carSourceNorthCentral_newCar_xjal( this );
      }
      @Override
      public double preferredSpeed( Car car ) {
        return _carSourceNorthCentral_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carSourceNorthCentral_xjal( final com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
300 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = 
self.BACKWARD_LANE 
;
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carSourceNorthCentral_xjal( com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarMoveTo<Vehicle> instantiate_carMoveToNorthWest_xjal() {
    com.anylogic.libraries.road.CarMoveTo<Vehicle> _result_xjal = new com.anylogic.libraries.road.CarMoveTo<Vehicle>( getEngine(), this, null ) {
      @Override
      public Road road( Vehicle car ) {
        return _carMoveToNorthWest_road_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carMoveToNorthWest_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
    self.movesTo = self._movesTo_DefaultValue_xjal();
    self.destination = 
self.END_OF_BACKWARD_LANE 
;
    self.stopLineBehavior = self._stopLineBehavior_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carMoveToNorthWest_xjal( com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarDispose<Vehicle> instantiate_carDispose_xjal() {
    com.anylogic.libraries.road.CarDispose<Vehicle> _result_xjal = new com.anylogic.libraries.road.CarDispose<Vehicle>( getEngine(), this, null ) {
      @Override
      public void onEnter( Vehicle car ) {
        _carDispose_onEnter_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carDispose_xjal( final com.anylogic.libraries.road.CarDispose<Vehicle> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carDispose_xjal( com.anylogic.libraries.road.CarDispose<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarMoveTo<Vehicle> instantiate_carMoveToSouthWest_xjal() {
    com.anylogic.libraries.road.CarMoveTo<Vehicle> _result_xjal = new com.anylogic.libraries.road.CarMoveTo<Vehicle>( getEngine(), this, null ) {
      @Override
      public Road road( Vehicle car ) {
        return _carMoveToSouthWest_road_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carMoveToSouthWest_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
    self.movesTo = self._movesTo_DefaultValue_xjal();
    self.destination = 
self.END_OF_BACKWARD_LANE 
;
    self.stopLineBehavior = self._stopLineBehavior_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carMoveToSouthWest_xjal( com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Car> instantiate_carSourceNorthWest_xjal() {
    com.anylogic.libraries.road.CarSource<Car> _result_xjal = new com.anylogic.libraries.road.CarSource<Car>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Car car ) {
        return _carSourceNorthWest_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _carSourceNorthWest_newCar_xjal( this );
      }
      @Override
      public double preferredSpeed( Car car ) {
        return _carSourceNorthWest_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carSourceNorthWest_xjal( final com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
2000 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = self._laneDirection_DefaultValue_xjal();
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carSourceNorthWest_xjal( com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarMoveTo<Vehicle> instantiate_carMoveToSouthEast1_xjal() {
    com.anylogic.libraries.road.CarMoveTo<Vehicle> _result_xjal = new com.anylogic.libraries.road.CarMoveTo<Vehicle>( getEngine(), this, null ) {
      @Override
      public Road road( Vehicle car ) {
        return _carMoveToSouthEast1_road_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carMoveToSouthEast1_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
    self.movesTo = self._movesTo_DefaultValue_xjal();
    self.destination = self._destination_DefaultValue_xjal();
    self.stopLineBehavior = self._stopLineBehavior_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carMoveToSouthEast1_xjal( com.anylogic.libraries.road.CarMoveTo<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Car> instantiate_carSourceSouthEast_xjal() {
    com.anylogic.libraries.road.CarSource<Car> _result_xjal = new com.anylogic.libraries.road.CarSource<Car>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Car car ) {
        return _carSourceSouthEast_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _carSourceSouthEast_newCar_xjal( this );
      }
      @Override
      public double preferredSpeed( Car car ) {
        return _carSourceSouthEast_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carSourceSouthEast_xjal( final com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
2000 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = 
self.BACKWARD_LANE 
;
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carSourceSouthEast_xjal( com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarMoveTo<Car> instantiate_carMoveToNorthEast_xjal() {
    com.anylogic.libraries.road.CarMoveTo<Car> _result_xjal = new com.anylogic.libraries.road.CarMoveTo<Car>( getEngine(), this, null ) {
      @Override
      public Road road( Car car ) {
        return _carMoveToNorthEast_road_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carMoveToNorthEast_xjal( final com.anylogic.libraries.road.CarMoveTo<Car> self, TableInput _t ) {
    self.movesTo = self._movesTo_DefaultValue_xjal();
    self.destination = self._destination_DefaultValue_xjal();
    self.stopLineBehavior = self._stopLineBehavior_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carMoveToNorthEast_xjal( com.anylogic.libraries.road.CarMoveTo<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Car> instantiate_carSourceSouthWest_xjal() {
    com.anylogic.libraries.road.CarSource<Car> _result_xjal = new com.anylogic.libraries.road.CarSource<Car>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Car car ) {
        return _carSourceSouthWest_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _carSourceSouthWest_newCar_xjal( this );
      }
      @Override
      public double preferredSpeed( Car car ) {
        return _carSourceSouthWest_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carSourceSouthWest_xjal( final com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
1000 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = self._laneDirection_DefaultValue_xjal();
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carSourceSouthWest_xjal( com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarMoveTo<Car> instantiate_carMoveToNorthCenter_xjal() {
    com.anylogic.libraries.road.CarMoveTo<Car> _result_xjal = new com.anylogic.libraries.road.CarMoveTo<Car>( getEngine(), this, null ) {
      @Override
      public Road road( Car car ) {
        return _carMoveToNorthCenter_road_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carMoveToNorthCenter_xjal( final com.anylogic.libraries.road.CarMoveTo<Car> self, TableInput _t ) {
    self.movesTo = self._movesTo_DefaultValue_xjal();
    self.destination = self._destination_DefaultValue_xjal();
    self.stopLineBehavior = self._stopLineBehavior_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carMoveToNorthCenter_xjal( com.anylogic.libraries.road.CarMoveTo<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> instantiate_selectOutput7_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle>( getEngine(), this, null ) {
      @Override
      public double probability1( Vehicle agent ) {
        return _selectOutput7_probability1_xjal( this, agent );
      }
      @Override
      public double probability2( Vehicle agent ) {
        return _selectOutput7_probability2_xjal( this, agent );
      }
      @Override
      public double probability3( Vehicle agent ) {
        return _selectOutput7_probability3_xjal( this, agent );
      }
      @Override
      public double probability4( Vehicle agent ) {
        return _selectOutput7_probability4_xjal( this, agent );
      }
      @Override
      public double probability5( Vehicle agent ) {
        return _selectOutput7_probability5_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput7_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_selectOutput7_xjal( com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Car> instantiate_carSourceNorthEast_xjal() {
    com.anylogic.libraries.road.CarSource<Car> _result_xjal = new com.anylogic.libraries.road.CarSource<Car>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Car car ) {
        return _carSourceNorthEast_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _carSourceNorthEast_newCar_xjal( this );
      }
      @Override
      public double preferredSpeed( Car car ) {
        return _carSourceNorthEast_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carSourceNorthEast_xjal( final com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
300 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = 
self.BACKWARD_LANE 
;
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carSourceNorthEast_xjal( com.anylogic.libraries.road.CarSource<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Car> instantiate_selectOutput_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Car> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Car>( getEngine(), this, null ) {
      @Override
      public double probability( Car agent ) {
        return _selectOutput_probability_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Car> self, TableInput _t ) {
    self.conditionIsProbabilistic = self._conditionIsProbabilistic_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_selectOutput_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> instantiate_roadNetworkDescriptor_xjal() {
    com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> _result_xjal = new com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_roadSectionLength() {
        return METER;
      }
      @Override
      public void onEnterNetwork( Vehicle car ) {
        _roadNetworkDescriptor_onEnterNetwork_xjal( this, car );
      }
      @Override
      public void onExitNetwork( Vehicle car ) {
        _roadNetworkDescriptor_onExitNetwork_xjal( this, car );
      }
      @Override
      public void onStop( Vehicle car, Road road, boolean isRoadForward ) {
        _roadNetworkDescriptor_onStop_xjal( this, car, road, isRoadForward );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_roadNetworkDescriptor_xjal( final com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> self, TableInput _t ) {
    self.roadNetwork = 
roadNetwork 
;
    self.roadSectionLength = 
20 
;
    self.enableDensityMap = self._enableDensityMap_DefaultValue_xjal();
    self.greenSpeedLevel = self._greenSpeedLevel_DefaultValue_xjal();
    self.redSpeedLevel = self._redSpeedLevel_DefaultValue_xjal();
    self.densityMapTransparency = self._densityMapTransparency_DefaultValue_xjal();
    self.automaticallyResolveDeadlocks = self._automaticallyResolveDeadlocks_DefaultValue_xjal();
    self.geometricCalculationsPrecision = 
1E-6 
;
    self.temporalCalculationsPrecision = self._temporalCalculationsPrecision_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_roadNetworkDescriptor_xjal( com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Bus> instantiate_busSourceNorthEast_xjal() {
    com.anylogic.libraries.road.CarSource<Bus> _result_xjal = new com.anylogic.libraries.road.CarSource<Bus>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Bus car ) {
        return _busSourceNorthEast_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _busSourceNorthEast_newCar_xjal( this );
      }
      @Override
      public double length( Bus car ) {
        return _busSourceNorthEast_length_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_length() {
        return METER;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_busSourceNorthEast_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
10 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = 
self.BACKWARD_LANE 
;
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_busSourceNorthEast_xjal( com.anylogic.libraries.road.CarSource<Bus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarDispose<Vehicle> instantiate_carWayNotFoundDispose_xjal() {
    com.anylogic.libraries.road.CarDispose<Vehicle> _result_xjal = new com.anylogic.libraries.road.CarDispose<Vehicle>( getEngine(), this, null ) {
      @Override
      public void onEnter( Vehicle car ) {
        _carWayNotFoundDispose_onEnter_xjal( this, car );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_carWayNotFoundDispose_xjal( final com.anylogic.libraries.road.CarDispose<Vehicle> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_carWayNotFoundDispose_xjal( com.anylogic.libraries.road.CarDispose<Vehicle> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Car> instantiate_selectOutput2_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Car> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Car>( getEngine(), this, null ) {
      @Override
      public double probability( Car agent ) {
        return _selectOutput2_probability_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput2_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Car> self, TableInput _t ) {
    self.conditionIsProbabilistic = self._conditionIsProbabilistic_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_selectOutput2_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Car> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Truck> instantiate_truckSourceNorthEast_xjal() {
    com.anylogic.libraries.road.CarSource<Truck> _result_xjal = new com.anylogic.libraries.road.CarSource<Truck>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Truck car ) {
        return _truckSourceNorthEast_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _truckSourceNorthEast_newCar_xjal( this );
      }
      @Override
      public double length( Truck car ) {
        return _truckSourceNorthEast_length_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_length() {
        return METER;
      }
      @Override
      public double initialSpeed( Truck car ) {
        return _truckSourceNorthEast_initialSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_initialSpeed() {
        return KPH;
      }
      @Override
      public double preferredSpeed( Truck car ) {
        return _truckSourceNorthEast_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_truckSourceNorthEast_xjal( final com.anylogic.libraries.road.CarSource<Truck> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
50 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = 
self.BACKWARD_LANE 
;
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_truckSourceNorthEast_xjal( com.anylogic.libraries.road.CarSource<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.road.CarSource<Bus> instantiate_truckSourceNorthWest_xjal() {
    com.anylogic.libraries.road.CarSource<Bus> _result_xjal = new com.anylogic.libraries.road.CarSource<Bus>( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public Road road( Bus car ) {
        return _truckSourceNorthWest_road_xjal( this, car );
      }
      @Override
      public Agent newCar(  ) {
        return _truckSourceNorthWest_newCar_xjal( this );
      }
      @Override
      public double length( Bus car ) {
        return _truckSourceNorthWest_length_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_length() {
        return METER;
      }
      @Override
      public double initialSpeed( Bus car ) {
        return _truckSourceNorthWest_initialSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_initialSpeed() {
        return KPH;
      }
      @Override
      public double preferredSpeed( Bus car ) {
        return _truckSourceNorthWest_preferredSpeed_xjal( this, car );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_preferredSpeed() {
        return KPH;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_truckSourceNorthWest_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, TableInput _t ) {
    self.arrivalType = self._arrivalType_DefaultValue_xjal();
    self.rate = 
50 
;
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.appears = self._appears_DefaultValue_xjal();
    self.laneDirection = self._laneDirection_DefaultValue_xjal();
    self.isRandomLane = self._isRandomLane_DefaultValue_xjal();
    self.addCarToCustomPopulation = self._addCarToCustomPopulation_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_truckSourceNorthWest_xjal( com.anylogic.libraries.road.CarSource<Bus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine9_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine9_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine9;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine9_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine8_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine8_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine8;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine8_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine2_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine2_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine2;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine2_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine5_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine5_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine5;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine5_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine4_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine4_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine4;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine4_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine3_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine3_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine3;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine3_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine6_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine6_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine6;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine6_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine7_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine7_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine7;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine7_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine1_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine1_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine1;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine1_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> instantiate__stopLine10_controller_xjal_xjal() {
    com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _result_xjal = new com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters__stopLine10_controller_xjal_xjal( final com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> _self, TableInput _t ) {
    StopLine<Agent> self = stopLine10;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate__stopLine10_controller_xjal_xjal( com.anylogic.libraries.modules.markup_descriptors.StopLineDescriptor<Agent> self, TableInput _t ) {
  }

  private Road _carSourceNorthCentral_road_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    Road _value;
    _value = 
road4 
;
    return _value;
  }
  private Agent _carSourceNorthCentral_newCar_xjal( final com.anylogic.libraries.road.CarSource<Car> self ) {
    Agent _value;
    _value = 
new city_square.Car() 
;
    return _value;
  }
  private double _carSourceNorthCentral_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    double _value;
    _value = 
60 
;
    return _value;
  }
  private Road _carMoveToNorthWest_road_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, Vehicle car ) {
    Road _value;
    _value = 
road 
;
    return _value;
  }
  private void _carDispose_onEnter_xjal( final com.anylogic.libraries.road.CarDispose<Vehicle> self, Vehicle car ) {
    
onVehicleArrived(car); 
;
  }
  private Road _carMoveToSouthWest_road_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, Vehicle car ) {
    Road _value;
    _value = 
road2 
;
    return _value;
  }
  private Road _carSourceNorthWest_road_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    Road _value;
    _value = 
road 
;
    return _value;
  }
  private Agent _carSourceNorthWest_newCar_xjal( final com.anylogic.libraries.road.CarSource<Car> self ) {
    Agent _value;
    _value = 
new city_square.Car() 
;
    return _value;
  }
  private double _carSourceNorthWest_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    double _value;
    _value = 
uniform(60, 80) 
;
    return _value;
  }
  private Road _carMoveToSouthEast1_road_xjal( final com.anylogic.libraries.road.CarMoveTo<Vehicle> self, Vehicle car ) {
    Road _value;
    _value = 
road1 
;
    return _value;
  }
  private Road _carSourceSouthEast_road_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    Road _value;
    _value = 
road1 
;
    return _value;
  }
  private Agent _carSourceSouthEast_newCar_xjal( final com.anylogic.libraries.road.CarSource<Car> self ) {
    Agent _value;
    _value = 
new city_square.Car() 
;
    return _value;
  }
  private double _carSourceSouthEast_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    double _value;
    _value = 
uniform(60, 80) 
;
    return _value;
  }
  private Road _carMoveToNorthEast_road_xjal( final com.anylogic.libraries.road.CarMoveTo<Car> self, Car car ) {
    Road _value;
    _value = 
road10 
;
    return _value;
  }
  private Road _carSourceSouthWest_road_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    Road _value;
    _value = 
road2 
;
    return _value;
  }
  private Agent _carSourceSouthWest_newCar_xjal( final com.anylogic.libraries.road.CarSource<Car> self ) {
    Agent _value;
    _value = 
new city_square.Car() 
;
    return _value;
  }
  private double _carSourceSouthWest_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    double _value;
    _value = 
uniform(60, 80) 
;
    return _value;
  }
  private Road _carMoveToNorthCenter_road_xjal( final com.anylogic.libraries.road.CarMoveTo<Car> self, Car car ) {
    Road _value;
    _value = 
road4 
;
    return _value;
  }
  private double _selectOutput7_probability1_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, Vehicle agent ) {
    double _value;
    _value = 
0.3 
;
    return _value;
  }
  private double _selectOutput7_probability2_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, Vehicle agent ) {
    double _value;
    _value = 
0.3 
;
    return _value;
  }
  private double _selectOutput7_probability3_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, Vehicle agent ) {
    double _value;
    _value = 
0.3 
;
    return _value;
  }
  private double _selectOutput7_probability4_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, Vehicle agent ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  private double _selectOutput7_probability5_xjal( final com.anylogic.libraries.processmodeling.SelectOutput5<Vehicle> self, Vehicle agent ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  private Road _carSourceNorthEast_road_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    Road _value;
    _value = 
road10 
;
    return _value;
  }
  private Agent _carSourceNorthEast_newCar_xjal( final com.anylogic.libraries.road.CarSource<Car> self ) {
    Agent _value;
    _value = 
new city_square.Car() 
;
    return _value;
  }
  private double _carSourceNorthEast_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Car> self, Car car ) {
    double _value;
    _value = 
uniform(60, 80) 
;
    return _value;
  }
  private double _selectOutput_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Car> self, Car agent ) {
    double _value;
    _value = 
0.8 
;
    return _value;
  }
  private void _roadNetworkDescriptor_onEnterNetwork_xjal( final com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> self, Vehicle car ) {
    
if (selectedCar == null
		&& cbxCameraFollowToCar.isSelected()) {
	window3d.setCamera(car.camera, true);
	selectedCar = car;
} 
;
  }
  private void _roadNetworkDescriptor_onExitNetwork_xjal( final com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> self, Vehicle car ) {
    
if (cbxCameraFollowToCar.isSelected()
		&& selectedCar == car) {
	selectedCar = null;
} 
;
  }
  private void _roadNetworkDescriptor_onStop_xjal( final com.anylogic.libraries.road.RoadNetworkDescriptor<Vehicle> self, Vehicle car, Road road, boolean isRoadForward ) {
    
carStopsCounter++; 
;
  }
  private Road _busSourceNorthEast_road_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    Road _value;
    _value = 
road10 
;
    return _value;
  }
  private Agent _busSourceNorthEast_newCar_xjal( final com.anylogic.libraries.road.CarSource<Bus> self ) {
    Agent _value;
    _value = 
new city_square.Bus() 
;
    return _value;
  }
  private double _busSourceNorthEast_length_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    double _value;
    _value = 
10 
;
    return _value;
  }
  private void _carWayNotFoundDispose_onEnter_xjal( final com.anylogic.libraries.road.CarDispose<Vehicle> self, Vehicle car ) {
    
onVehicleArrived(car); 
;
  }
  private double _selectOutput2_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Car> self, Car agent ) {
    double _value;
    _value = 
0.95 
;
    return _value;
  }
  private Road _truckSourceNorthEast_road_xjal( final com.anylogic.libraries.road.CarSource<Truck> self, Truck car ) {
    Road _value;
    _value = 
road10 
;
    return _value;
  }
  private Agent _truckSourceNorthEast_newCar_xjal( final com.anylogic.libraries.road.CarSource<Truck> self ) {
    Agent _value;
    _value = 
new city_square.Truck() 
;
    return _value;
  }
  private double _truckSourceNorthEast_length_xjal( final com.anylogic.libraries.road.CarSource<Truck> self, Truck car ) {
    double _value;
    _value = 
12 
;
    return _value;
  }
  private double _truckSourceNorthEast_initialSpeed_xjal( final com.anylogic.libraries.road.CarSource<Truck> self, Truck car ) {
    double _value;
    _value = 
50 
;
    return _value;
  }
  private double _truckSourceNorthEast_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Truck> self, Truck car ) {
    double _value;
    _value = 
50 
;
    return _value;
  }
  private Road _truckSourceNorthWest_road_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    Road _value;
    _value = 
road 
;
    return _value;
  }
  private Agent _truckSourceNorthWest_newCar_xjal( final com.anylogic.libraries.road.CarSource<Bus> self ) {
    Agent _value;
    _value = 
new city_square.Bus() 
;
    return _value;
  }
  private double _truckSourceNorthWest_length_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    double _value;
    _value = 
12 
;
    return _value;
  }
  private double _truckSourceNorthWest_initialSpeed_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    double _value;
    _value = 
50 
;
    return _value;
  }
  private double _truckSourceNorthWest_preferredSpeed_xjal( final com.anylogic.libraries.road.CarSource<Bus> self, Bus car ) {
    double _value;
    _value = 
50 
;
    return _value;
  }
  // Functions

  void onVehicleArrived( Vehicle v ) { 

double timeInSystem = time() - v.startTime;
timeInSystemDS.add(timeInSystem);

double speedAtKph = v.getDistanceDriven(KILOMETER)
		/ toTimeUnits(timeInSystem, HOUR);
speedDS.add(speedAtKph);

long disposedCarCount = carDispose.count()
		+ carWayNotFoundDispose.count();
carStopsDS.add((disposedCarCount == 0)
		? 0
		: carStopsCounter / (double) disposedCarCount); 
  }

  void navigate( ViewArea viewArea ) { 

selectedViewArea = viewArea;
viewArea.navigateTo();
groupMainMenu.setPos(viewArea.getX(), viewArea.getY()); 
  }
  // Analysis Data Elements
  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression0_dataSet_xjal = new DataSet( 240, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression0_dataSet_xjal_YValue() {
    return 
roadNetworkDescriptor.size() 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot1_expression0_dataSet_xjal = new DataSet( 240, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot1_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot1_expression0_dataSet_xjal_YValue() {
    return 
speedDS.getYMean() 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot2_expression0_dataSet_xjal = new DataSet( 240, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot2_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot2_expression0_dataSet_xjal_YValue() {
    return 
timeInSystemDS.getYMean() 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot3_expression0_dataSet_xjal = new DataSet( 240, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot3_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot3_expression0_dataSet_xjal_YValue() {
    return 
carStopsDS.getYMean() 
;
  }

  public DataSet speedDS = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  public DataSet timeInSystemDS = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  public DataSet carStopsDS = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), 0 );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );
  
  // View areas
  public ViewArea view2D = new ViewArea( this, null, -180, 50, 1150, 700 );
  public ViewArea view3D = new ViewArea( this, null, -1950, 0, 1150, 700 );
  public ViewArea viewLogic = new ViewArea( this, null, 1800, 0, 1150, 700 );
  public ViewArea viewStatistics = new ViewArea( this, null, 3100, 0, 1150, 700 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1150.0, 700.0 );
  @AnyLogicInternalCodegenAPI
  public ViewArea _window3d_VA = new ViewArea( this, "[window3d]", -1950.0, 50.0, 1150.0, 650.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "view2D", this.view2D );
      _output.put( "view3D", this.view3D );
      _output.put( "viewLogic", this.viewLogic );
      _output.put( "viewStatistics", this.viewStatistics );
      _output.put( "_origin_VA", this._origin_VA );
      _output.put( "_window3d_VA", this._window3d_VA );
    }
    return 6 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox1_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _cbxCameraFollowToCar_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox7_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text96_Font = new Font("SansSerif", 0, 26 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text97_Font = _text96_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text99_Font = _text96_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text98_Font = _text96_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text115_Font = _text96_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _building_1_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_11", null ),
    new Pair<String, Color>( "MA_material", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _billboard_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_000", null ),
    new Pair<String, Color>( "MA_Color_002", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_3_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_4_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_5_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_2_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_6_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_7_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_8_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_1_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_9_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_10_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _store_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "Material__3__Surf", null ),
    new Pair<String, Color>( "Material__2__Surf", null ),
    new Pair<String, Color>( "Material__5__Surf", null ),
    new Pair<String, Color>( "Material__4__Surf", null ),
    new Pair<String, Color>( "Material__1__Surf", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _building_2_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_material_12", null ),
    new Pair<String, Color>( "MA_material_10", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _building_3_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_12", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_material_10", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _building_4_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_11", peru ),
    new Pair<String, Color>( "MA_material", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _hospital_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_material_8", null ),
    new Pair<String, Color>( "MA_material_7", null ),
    new Pair<String, Color>( "MA_material_11", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _auto_service_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_material_7", null ),
    new Pair<String, Color>( "MA_material_8", null ),
    new Pair<String, Color>( "MA_material_6", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_11_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_12_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_13_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_14_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _building_5_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_11", null ),
    new Pair<String, Color>( "MA_material", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _bench_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "material0", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _bench1_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "material0", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _bench4_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "material0", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _bench5_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "material0", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_15_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_16_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_17_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_18_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_19_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_20_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _warehouse_2_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_11", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_material_8", null ),
    new Pair<String, Color>( "MA_material_6", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_21_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_22_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_23_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_24_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_25_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_26_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_27_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_28_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_29_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_30_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_31_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_32_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_33_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_34_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_35_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_36_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_37_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_38_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_39_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_40_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_41_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_42_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_43_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_44_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_45_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_46_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_47_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_48_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_49_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_50_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_51_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_52_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_material", null ),
    new Pair<String, Color>( "MA_Color_E16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_53_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_54_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _bench6_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "material0", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_55_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _tree_56_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_C18", null ),
    new Pair<String, Color>( "MA_Color_F16", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _ad_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_000", null ),
    new Pair<String, Color>( "MA_Color_002", null ),
    new Pair<String, Color>( "MA_material", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _ad1_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_Color_000", null ),
    new Pair<String, Color>( "MA_Color_002", null ),
    new Pair<String, Color>( "MA_material", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Color _light1_DiffuseColor = new Color( 0xFF525252, true );
  protected static final Color _rectangle128_Fill_Color = new Color( 0xFF505050, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _window3d = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox1 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _cbxCameraFollowToCar = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox7 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot1 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot2 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot3 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _building_1 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _camera = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _billboard = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_3 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_4 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_5 = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_2 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_6 = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_7 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_8 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_1 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_9 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_10 = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _store = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _building_2 = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _building_3 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _building_4 = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _hospital = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _auto_service = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_11 = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_12 = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_13 = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_14 = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _light = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _building_5 = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _bench = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _bench1 = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _bench4 = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _bench5 = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_15 = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_16 = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_17 = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_18 = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_19 = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_20 = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline1 = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _warehouse_2 = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_21 = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_22 = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_23 = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_24 = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_25 = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_26 = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_27 = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_28 = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_29 = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_30 = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_31 = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_32 = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_33 = 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_34 = 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_35 = 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_36 = 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_37 = 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_38 = 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_39 = 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_40 = 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_41 = 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_42 = 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_43 = 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_44 = 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_45 = 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_46 = 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_47 = 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_48 = 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_49 = 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_50 = 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_51 = 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_52 = 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_53 = 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline2 = 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_54 = 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _bench6 = 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_55 = 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _tree_56 = 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _ad = 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _ad1 = 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _light1 = 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle105 = 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle106 = 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _text96 = 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle107 = 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _text97 = 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle109 = 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle108 = 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _text99 = 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _text98 = 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle128 = 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _text115 = 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupMainMenu = 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _road4 = 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine9 = 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine8 = 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _road = 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _road5 = 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine2 = 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _road6 = 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine5 = 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _road7 = 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine4 = 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _road3 = 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _road8 = 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine3 = 117;
  @AnyLogicInternalCodegenAPI
  protected static final int _road9 = 118;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine6 = 119;
  @AnyLogicInternalCodegenAPI
  protected static final int _road10 = 120;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine7 = 121;
  @AnyLogicInternalCodegenAPI
  protected static final int _road1 = 122;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine = 123;
  @AnyLogicInternalCodegenAPI
  protected static final int _road2 = 124;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine1 = 125;
  @AnyLogicInternalCodegenAPI
  protected static final int _road11 = 126;
  @AnyLogicInternalCodegenAPI
  protected static final int _stopLine10 = 127;
  @AnyLogicInternalCodegenAPI
  protected static final int _intersection1 = 128;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector = 129;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector16 = 130;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector17 = 131;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector4 = 132;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector6 = 133;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector25 = 134;
  @AnyLogicInternalCodegenAPI
  protected static final int _intersection = 135;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector2 = 136;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector5 = 137;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector3 = 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector8 = 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector13 = 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector14 = 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector36 = 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector23 = 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector41 = 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector43 = 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector44 = 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector45 = 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector1 = 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _intersection2 = 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector21 = 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector28 = 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector19 = 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector15 = 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector22 = 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector30 = 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector7 = 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector18 = 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector20 = 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _intersection3 = 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector9 = 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector10 = 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector11 = 162;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector12 = 163;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector26 = 164;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector27 = 165;
  @AnyLogicInternalCodegenAPI
  protected static final int _intersection4 = 166;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector33 = 167;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector34 = 168;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector35 = 169;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector37 = 170;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector29 = 171;
  @AnyLogicInternalCodegenAPI
  protected static final int _laneConnector31 = 172;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 173;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDX_xjal() {
    return new double[] { 0.0, 345.0, 380.0, 1100.0, 1060.0, 375.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDY_xjal() {
    return new double[] { 0.0, -775.0, -780.0, -30.0, 10.0, -720.0, 20.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 770.0, 810.0, 190.0, 60.0, 50.0, 510.0, 480.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDY_xjal() {
    return new double[] { 0.0, 90.0, 860.0, 820.0, 200.0, 80.0, 0.0, -1100.0, -1110.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDX_xjal() {
    return new double[] { 0.0, 360.0, -370.0, -330.0, 420.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDY_xjal() {
    return new double[] { 0.0, -790.0, -1570.0, -1600.0, -800.0, 20.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rectangle, building_1, roadNetwork, camera, text1, text2, text3, text6, billboard, tree_3, tree_4, tree_5, tree_2, tree_6, tree_7, tree_8, tree_1, tree_9, tree_10, store, building_2, building_3, building_4, hospital, auto_service, tree_11, tree_12, tree_13, tree_14, light, building_5, bench, bench1, bench4, bench5, polyline, tree_15, tree_16, tree_17, tree_18, tree_19, tree_20, polyline1, warehouse_2, tree_21, tree_22, tree_23, tree_24, tree_25, tree_26, tree_27, tree_28, tree_29, tree_30, tree_31, tree_32, tree_33, tree_34, tree_35, tree_36, tree_37, tree_38, tree_39, tree_40, tree_41, tree_42, tree_43, tree_44, tree_45, tree_46, tree_47, tree_48, tree_49, tree_50, tree_51, tree_52, tree_53, polyline2, tree_54, bench6, tree_55, tree_56, ad, ad1, light1, groupMainMenu, window3d, checkbox1, cbxCameraFollowToCar, checkbox7, plot, plot1, plot2, plot3);
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_roadNetwork_xjal() {
	  roadNetwork.addAll(road4, stopLine9, stopLine8, road, intersection1, intersection, road5, stopLine2, road6, stopLine5, intersection2, road7, stopLine4, road3, road8, stopLine3, road9, stopLine6, intersection3, road10, stopLine7, road1, stopLine, road2, stopLine1, intersection4, road11, stopLine10);
      trafficLight = _trafficLight_xjal();
      roadNetwork.add(trafficLight);
      trafficLight1 = _trafficLight1_xjal();
      roadNetwork.add(trafficLight1);
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road4_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 410.0, 150.0, 0.0, 236.10769764148222, -637.091473833291, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( -570.0, -440.0, 0.0, 159.33299999999997, 318.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road5_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 244.667, 405.99999999999994, 0.0, 360.0, 504.99999999999994, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road6_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 460.0, 300.0, 0.0, 460.0, 500.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road7_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 380.0, 270.0, 0.0, 258.4, 339.6, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road3_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 720.0, 10.0, 0.0, 580.0, 220.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road8_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 520.0, 490.0, 0.0, 575.0, 355.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road9_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 610.0, 260.0, 0.0, 730.0, 20.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road10_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 760.0, -50.0, 0.0, 1080.0, -780.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road1_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 535.0, 665.0, 0.0, 1380.0, 1520.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road2_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 60.0, 1519.9999999999998, 0.0, 430.0, 679.9999999999998, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _road11_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 218.540297886934, -709.6467929259403, 0.0, 200.0, -780.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private RoadLanesConnector[] _intersection1_laneConnectors_xjal() {
    return new RoadLanesConnector[] {
      laneConnector,
      laneConnector16,
      laneConnector17,
      laneConnector4,
      laneConnector6,
      laneConnector25,
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 247.96817194606814, 321.37427742301554, 0.0, 205.25807103533208, 315.25057484962383, 0.0, 4.19253465095912, 2.375466200662533, 1.0000000000000038,
			265.39644270367376, 351.82367001101596, 35.08432884606154, -2.090650656220467, -0.0,
			230.5399011884627, 290.92488483501535, 35.08432884606127, -5.23224330981026, 1.3245242032932065 ),
       new MarkupSegmentLine( 205.25807103533208, 315.25057484962383, 0.0, 184.55406263574457, 293.73277932016424, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector16_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 144.2003624185532, 332.56033240790146, 0.0, 222.25557384484358, 413.6835645407243, 0.0 ),
       new MarkupSegmentArc( 222.25557384484358, 413.6835645407243, 0.0, 230.98898386619177, 421.9346124723283, 0.0, 2.3754662006625376, -0.8614550202968787, 1.000000000000001,
			131.40064459998607, 501.10242748391596, 126.08201999638406, -0.7661264529272559, -0.0,
			313.1105030896998, 326.2647015975317, 126.08201999638378, -3.9077191065170553, -0.09532856736961666 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector17_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 154.28878747285106, 322.85344413596715, 0.0, 232.3439988991414, 403.97667626879, 0.0 ),
       new MarkupSegmentArc( 232.3439988991414, 403.97667626879, 0.0, 240.10766128873058, 411.31153749077606, 0.0, 2.375466200662533, -0.8614550202968769, 0.9999999999999993,
			151.5774947085751, 481.6886509400544, 112.08201999639374, -0.7661264529272599, -0.0,
			313.1105030897065, 326.26470159752415, 112.08201999639391, -3.907719106517061, -0.09532856736960824 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector4_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 249.22633871126942, 400.6884625092238, 0.0, 242.43242395343668, 394.26978799685304, 0.0, -0.8614550202968787, 2.375466200662533, 1.000000000000003,
			185.34217433280932, 475.11222342095056, 98.08201999642937, -0.8614550202968788, -0.0,
			313.11050308973046, 326.26470159749863, 98.08201999642878, -4.003047673886663, 0.09532856736961022 ),
       new MarkupSegmentLine( 242.43242395343668, 394.26978799685304, 0.0, 164.37721252714888, 313.14655586403285, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector6_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 258.34501613380826, 390.0653875276716, 0.0, 252.52084900773474, 384.56289972491896, 0.0, -0.8614550202968827, 2.375466200662533, 0.9999999999999991,
			203.57952917789612, 453.86607345783597, 84.08201999641575, -0.8614550202968828, -0.0,
			313.11050308972136, 326.26470159750784, 84.0820199964159, -4.00304767388667, 0.09532856736961666 ),
       new MarkupSegmentLine( 252.52084900773474, 384.56289972491896, 0.0, 174.4656375814467, 303.43966759209854, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector25_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 254.92272398202272, 333.5247591410052, 0.0, 217.70701392171708, 328.1888331046045, 0.0, 4.192534650959125, 2.3754662006625313, 0.9999999999999989,
			270.1089552841479, 360.05702532402864, 30.57094650102376, -2.090650656220462, -0.0,
			239.73649267989754, 306.99249295798165, 30.570946501023826, -5.232243309810253, 1.324524203293199 ),
       new MarkupSegmentLine( 217.70701392171708, 328.1888331046045, 0.0, 184.55406263574457, 293.73277932016424, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private RoadLanesConnector[] _intersection_laneConnectors_xjal() {
    return new RoadLanesConnector[] {
      laneConnector2,
      laneConnector5,
      laneConnector3,
      laneConnector8,
      laneConnector13,
      laneConnector14,
      laneConnector36,
      laneConnector23,
      laneConnector41,
      laneConnector43,
      laneConnector44,
      laneConnector45,
      laneConnector1,
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector2_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 549.936332477831, 650.2383614692782, 0.0, 526.1400641545938, 530.5880197077023, 0.0, -0.7795158783020741, 3.5284683713208294, 1.000000000000004,
			628.7173453886292, 572.3787639141615, 110.76355414438486, -3.9211085318918677, 1.1663915960331075,
			423.5627829205595, 488.7972755012429, 110.763554144384, -5.8963095894485535, -0.0 ),
       new MarkupSegmentLine( 526.1400641545938, 530.5880197077023, 0.0, 539.4479395551605, 497.9232346335839, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector5_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 453.0, 500.0, 0.0, 517.6614806850937, 657.4145352206195, 0.0, 3.141592653589793, -0.7795158783020741, 1.0,
			676.938909813649, 500.0, 223.93890981364908, -3.141592653589793, -0.7795158783020734,
			358.38405155653845, 814.8290704412393, 223.9389098136491, -0.7795158783020735, -0.0 ),
       new MarkupSegmentLine( 517.6614806850937, 657.4145352206195, 0.0, 530.0212225073897, 669.9205461769072, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector3_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 449.2182405935963, 688.4651774043219, 0.0, 485.3037908647283, 612.2805501436734, 0.0, 0.41490575769087523, 3.611394501536192, 0.9999999999999957,
			-956.272958793545, 69.37976815046079, 1535.796944750746, -5.868279549488712, -0.0,
			1854.7094399807538, 1307.5505866581811, 1535.7969447507596, -2.7266868958989208, 0.05489609025552622 ),
       new MarkupSegmentLine( 485.3037908647283, 612.2805501436734, 0.0, 504.4505384544809, 574.5690669291098, 0.0 ),
       new MarkupSegmentArc( 504.4505384544809, 574.5690669291098, 0.0, 539.4479395551605, 497.9232346335839, 0.0, 0.4698018479463988, 3.5284683713208205, 1.0000000000000033,
			1410.6884725889313, 1034.6811469130203, 1016.3514743490052, -2.6717908056433943, -0.0,
			-401.78739567996274, 114.45698694520104, 1016.3514743489984, -5.813383459233187, -0.08292613021537162 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector8_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 436.40608019786544, 682.8217258014405, 0.0, 472.42933898738454, 606.7812242236583, 0.0, 0.414905757690875, 3.61152285313088, 1.0,
			1836.0094617224413, 1299.313691472981, 1529.363256166627, -2.7266868958989177, 0.055024441850208244,
			-891.1507837476685, -85.75124302567212, 1529.3632561666266, -5.813255107638502, -0.0 ),
       new MarkupSegmentLine( 472.42933898738454, 606.7812242236583, 0.0, 491.5455132779221, 569.1419271249257, 0.0 ),
       new MarkupSegmentArc( 491.5455132779221, 569.1419271249257, 0.0, 526.4826465183868, 492.64107821119467, 0.0, 0.4699301995410867, 3.5284683713208205, 1.0000000000000007,
			1394.639770644822, 1027.803712952763, 1012.8918360159948, -2.6716624540487066, -0.0,
			-411.5487440889747, 110.4801412970852, 1012.8918360159937, -5.813255107638498, -0.08305448181006009 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector13_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 439.0, 500.0, 0.0, 439.0, 537.4693523620841, 0.0 ),
       new MarkupSegmentArc( 439.0, 537.4693523620841, 0.0, 410.7817594064037, 671.5348225956776, 0.0, 3.141592653589793, 0.41490575769087235, 0.9999999999999959,
			771.5830919347277, 537.4693523620841, 332.5830919347277, -3.141592653589793, -0.0,
			106.41690806526964, 537.4693523620836, 332.58309193473036, 0.0, 0.41490575769087207 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector14_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 453.0, 500.0, 0.0, 453.0, 537.4693523620842, 0.0 ),
       new MarkupSegmentArc( 453.0, 537.4693523620842, 0.0, 423.59391980213456, 677.178274198559, 0.0, 3.141592653589793, 0.41490575769087235, 0.9999999999999959,
			799.5830919347278, 537.4693523620842, 346.5830919347278, -3.141592653589793, -0.0,
			106.41690806526941, 537.4693523620836, 346.58309193473053, 0.0, 0.41490575769087207 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector36_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 449.2182405935963, 688.4651774043219, 0.0, 516.4212985769258, 676.0761646275467, 0.0, 0.414905757690877, -0.7795158783020661, 0.9999999999999856,
			487.0323433858658, 705.121389348536, 41.31991972783705, -2.7266868958989163, 1.947171017596847,
			545.8102537679869, 647.0309399065569, 41.31991972783825, -3.9211085318918624, -0.0 ),
       new MarkupSegmentLine( 516.4212985769258, 676.0761646275467, 0.0, 520.063667522169, 679.7616385307218, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector23_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 346.3219838661918, 520.9346124723282, 0.0, 383.9131249126599, 553.2022458782081, 0.0 ),
       new MarkupSegmentArc( 383.9131249126599, 553.2022458782081, 0.0, 410.7817594064037, 671.5348225956776, 0.0, 2.280137633292915, 0.41490575769087235, 0.999999999999997,
			450.24791310874696, 475.92355772649785, 101.8444881545831, -4.003047673886671, -0.0,
			317.57833671657215, 630.4809340299187, 101.84448815458376, -0.861455020296877, 1.2763607779877488 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector41_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 346.3219838661918, 520.9346124723282, 0.0, 388.7516869839802, 557.3555900647004, 0.0 ),
       new MarkupSegmentArc( 388.7516869839802, 557.3555900647004, 0.0, 520.063667522169, 679.7616385307218, 0.0, 2.280137633292915, -0.7795158783020741, 1.000000000000001,
			1816.1251744981287, -1105.5056870612534, 2191.4613160681756, -4.003047673886672, -0.0,
			-1038.6218005301712, 2220.2168671906456, 2191.4613160681706, -0.8614550202968768, 0.08193914199480269 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector43_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 355.44066128873055, 510.31153749077606, 0.0, 397.87036440651923, 546.7325150831484, 0.0 ),
       new MarkupSegmentArc( 397.87036440651923, 546.7325150831484, 0.0, 530.0212225073897, 669.9205461769072, 0.0, 2.280137633292915, -0.7795158783020741, 1.000000000000001,
			1834.3625293431908, -1126.7518370243395, 2205.461316068152, -4.003047673886672, -0.0,
			-1038.6218005301541, 2220.2168671906284, 2205.4613160681474, -0.8614550202968773, 0.08193914199480307 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector44_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 549.936332477831, 650.2383614692782, 0.0, 416.10771925159594, 525.4863651200432, 0.0, -0.7795158783020741, 2.280137633292915, 0.9999999999999989,
			-1038.6218005301637, 2220.2168671906384, 2233.4613160681606, -0.7795158783020741, -0.0819391419948033,
			1870.8372390333539, -1169.2441369505596, 2233.461316068166, -4.0030476738866705, -0.0 ),
       new MarkupSegmentLine( 416.10771925159594, 525.4863651200432, 0.0, 373.6780161338082, 489.06538752767165, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector45_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 539.9787774926103, 660.0794538230928, 0.0, 406.9890418290578, 536.1094401015959, 0.0, -0.7795158783020741, 2.280137633292915, 0.9999999999999989,
			-1038.6218005301894, 2220.216867190664, 2219.461316068197, -0.7795158783020741, -0.08193914199480219,
			1852.5998841883006, -1147.9979869874817, 2219.4613160682015, -4.00304767388667, -0.0 ),
       new MarkupSegmentLine( 406.9890418290578, 536.1094401015959, 0.0, 364.55933871126945, 499.6884625092238, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector1_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 453.0, 500.0, 0.0, 453.0, 516.499122093698, 0.0 ),
       new MarkupSegmentArc( 453.0, 516.499122093698, 0.0, 520.063667522169, 679.7616385307218, 0.0, 3.141592653589793, -0.7795158783020741, 1.0,
			685.2582847454296, 516.499122093698, 232.2582847454296, -3.141592653589793, -0.7795158783020728,
			354.86905029890875, 843.024154967746, 232.2582847454296, -0.779515878302073, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private RoadLanesConnector[] _intersection2_laneConnectors_xjal() {
    return new RoadLanesConnector[] {
      laneConnector21,
      laneConnector28,
      laneConnector19,
      laneConnector15,
      laneConnector22,
      laneConnector30,
      laneConnector7,
      laneConnector18,
      laneConnector20,
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector21_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 594.4479395551605, 362.9232346335839, 0.0, 607.9139809061048, 325.45040179404407, 0.0, 0.386875717731028, 3.444685463683087, 0.9999999999999956,
			1034.7143254240968, 542.2910214690764, 475.4022438739196, -2.754716935858766, -0.0,
			154.18155368622052, 183.55544779808938, 475.4022438739238, -5.896309589448558, -0.08378290763773413 ),
       new MarkupSegmentLine( 607.9139809061048, 325.45040179404407, 0.0, 613.9237029769457, 306.233328139703, 0.0 ),
       new MarkupSegmentArc( 613.9237029769457, 306.233328139703, 0.0, 628.7829710109983, 269.39148550549913, 0.0, 0.3030928100932935, 3.6052402625906006, 1.000000000000003,
			850.3260424129548, 380.1630212064774, 247.6926837994323, -2.8384998434965, 0.16055479890751334,
			407.2398996090431, 158.61994980452118, 247.69268379943085, -5.819537698178779, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector28_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 574.175647939635, 216.1170986264234, 0.0, 529.4796168233194, 248.72265600875335, 0.0, 3.7295952571373583, 1.2930928118481728, 0.9999999999999969,
			640.834877903186, 260.5565852687904, 80.11442387217598, -2.553590050042228, -0.0,
			507.5164179760838, 171.67761198405603, 80.11442387217647, -5.695182703632021, 0.7050902083006072 ),
       new MarkupSegmentLine( 529.4796168233194, 248.72265600875335, 0.0, 481.34605909227395, 262.4440694111905, 0.0 ),
       new MarkupSegmentArc( 481.34605909227395, 262.4440694111905, 0.0, 453.0, 300.0, 0.0, 4.434685465437966, 0.0, 0.999999999999998,
			470.64000548614473, 224.88813882238117, 39.05211269840312, -4.990092495331413, -0.0,
			492.0521126984033, 300.0, 39.052112698403285, -1.848499841741621, -1.2930928118481724 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector19_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 581.4826465183868, 357.6410782111946, 0.0, 595.1184918109219, 319.773009695225, 0.0, 0.38687571773102825, 3.4459842851093287, 0.9999999999999951,
			1033.4998496458843, 541.7962350409159, 488.090845755362, -2.7547169358587653, -0.0,
			129.4654433908853, 173.4859213814704, 488.0908457553668, -5.896309589448557, -0.08248408621149331 ),
       new MarkupSegmentLine( 595.1184918109219, 319.773009695225, 0.0, 601.2169327354463, 300.36078651238586, 0.0 ),
       new MarkupSegmentArc( 601.2169327354463, 300.36078651238586, 0.0, 616.2609903369994, 263.1304951684997, 0.0, 0.3043916315195301, 3.6052402625905966, 1.0000000000000027,
			360.41279432840247, 224.71103745352758, 252.40744364346108, -5.978793675660056, -0.0,
			842.021071142489, 376.01053557124374, 252.40744364345974, -2.837201022070263, 0.15925597748127301 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector15_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 562.5269438189052, 208.3512958792702, 0.0, 439.2949965462534, 185.2536430025708, 0.0, 3.729595257137356, 2.9241552341868466, 0.9999999999999979,
			619.2230810972003, 246.1487207314665, 68.14027669254585, -2.553590050042231, -0.0,
			505.83080654061007, 170.55387102707348, 68.14027669254617, -5.695182703632021, 2.336152630639281 ),
       new MarkupSegmentLine( 439.2949965462534, 185.2536430025708, 0.0, 430.5055229843869, 145.46971003833312, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector22_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 389.4944770156131, 154.53028996166688, 0.0, 397.19223776215796, 189.37278597234365, 0.0 ),
       new MarkupSegmentArc( 397.19223776215796, 189.37278597234365, 0.0, 369.5681719460681, 251.77427742301558, 0.0, 2.9241552341868466, 1.0509419973693301, 0.999999999999997,
			453.4224413194991, 176.9498340236288, 57.58615742711177, -3.35903007299274, -0.0,
			340.9620342048164, 201.79573792105856, 57.586157427112134, -0.2174374194029461, 1.2683794167722768 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector30_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 581.4826465183868, 357.6410782111946, 0.0, 556.3756859361197, 280.2016648092234, 0.0, 0.38687571773102913, 2.127674851455529, 0.9999999999999992,
			522.9965097116942, 333.81339284550495, 63.15367596947518, -5.896309589448557, -1.4007935198652932,
			589.7548621605453, 226.58993677294183, 63.1536759694753, -4.155510455724058, -0.0 ),
       new MarkupSegmentLine( 556.3756859361197, 280.2016648092234, 0.0, 473.51268272697985, 228.61036402646897, 0.0 ),
       new MarkupSegmentArc( 473.51268272697985, 228.61036402646897, 0.0, 416.83517432812897, 148.48990334611105, 0.0, -1.013917802134264, 2.924155234186846, 1.0000000000000013,
			406.633252806983, 336.02828782378174, 126.53643151025345, -1.013917802134264, -0.0,
			540.3921126469764, 121.19244022915643, 126.53643151025312, -4.155510455724057, 0.7964803827313174 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector7_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 403.16482567187103, 151.51009665388895, 0.0, 419.3793952714415, 210.33639421306978, 0.0, 2.924155234186845, -0.32047498461598356, 0.9999999999999998,
			981.6877927008686, 23.696883007947164, 592.4736626741628, -3.3590300729927414, -0.10303756521303234,
			-142.92900215798494, 396.9759054181951, 592.473662674163, -0.32047498461598084, -0.0 ),
       new MarkupSegmentLine( 419.3793952714415, 210.33639421306978, 0.0, 429.37604350256896, 240.45434303438344, 0.0 ),
       new MarkupSegmentArc( 429.37604350256896, 240.45434303438344, 0.0, 439.0, 300.0, 0.0, 2.82111766897381, 0.0, 1.0000000000000018,
			249.9766080560257, 300.0, 189.0233919439743, -0.32047498461598295, 0.32047498461598295,
			628.0233919439736, 300.0, 189.02339194397362, -3.141592653589793, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector18_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 562.5269438189052, 208.3512958792702, 0.0, 502.1825203985565, 241.83787404896574, 0.0, 3.729595257137361, 1.540358270717288, 1.0000000000000009,
			499.89154668015294, 166.59436445343536, 75.27837868094058, -5.695182703632019, 0.9523556671697204,
			504.47349411696, 317.081383644496, 75.27837868094046, -1.6012343828725053, -0.0 ),
       new MarkupSegmentLine( 502.1825203985565, 241.83787404896574, 0.0, 449.0270379531039, 243.45632345312302, 0.0 ),
       new MarkupSegmentArc( 449.0270379531039, 243.45632345312302, 0.0, 376.52272398202274, 263.9247591410052, 0.0, 4.681950924307081, 1.0509419973693286, 0.9999999999999989,
			453.75886998382293, 398.8660716958742, 155.48176768754027, -1.601234382872505, -0.48941627334795984,
			299.28657798022243, 128.9834465861359, 155.4817676875406, -5.232243309810258, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector20_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 403.16482567187103, 151.51009665388895, 0.0, 416.83517432812897, 148.48990334611105, 0.0, 2.9241552341868466, 2.9241552341868466, 1.0,
			410.0, 150.0, 6.999999999999995, -3.35903007299274, -3.141592653589793,
			423.67034865625794, 146.9798066922221, 6.999999999999996, -3.35903007299274, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private RoadLanesConnector[] _intersection3_laneConnectors_xjal() {
    return new RoadLanesConnector[] {
      laneConnector9,
      laneConnector10,
      laneConnector11,
      laneConnector12,
      laneConnector26,
      laneConnector27,
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector9_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 740.7667477659113, -58.43101467795671, 0.0, 726.9472103445011, -35.01958496517635, 0.0, 3.5547214858681975, 0.6533698585384758, 1.0000000000000029,
			636.8763720131727, -103.97200130929454, 113.4336442040055, -5.870056474901182, 0.24024102626007138,
			817.0180486758288, 33.932831378941515, 113.43364420400484, -2.488222795051318, -0.0 ),
       new MarkupSegmentLine( 726.9472103445011, -35.01958496517635, 0.0, 718.4443569669213, -23.912517620287034, 0.0 ),
       new MarkupSegmentArc( 718.4443569669213, -23.912517620287034, 0.0, 702.5269438189052, -1.6487041207298176, 0.0, 3.7949625121282757, 0.588002603547567, 1.0000000000000036,
			1050.9601799018114, 230.64011993453917, 418.76463292425484, -2.4882227950513105, -0.06536725499091742,
			354.09370773600233, -233.93752817599815, 418.7646329242518, -5.695182703632021, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector10_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 753.5889159219704, -52.81033822598556, 0.0, 739.3369336451883, -28.52112906256619, 0.0, 3.5547214858681953, 0.6481286186286777, 1.0000000000000042,
			643.5805955809246, -101.03316358096457, 120.11357720705406, -5.870056474901184, 0.23499978635027524,
			835.0932717094512, 43.99090545583155, 120.1135772070531, -2.4934640349611152, -0.0 ),
       new MarkupSegmentLine( 739.3369336451883, -28.52112906256619, 0.0, 730.6001289068571, -16.98367278125309, 0.0 ),
       new MarkupSegmentArc( 730.6001289068571, -16.98367278125309, 0.0, 714.175647939635, 6.117098626423399, 0.0, 3.789721272218477, 0.5880026035475681, 1.0000000000000002,
			354.7221950338953, -301.6193874157151, 471.4888240648739, -5.635056688550903, -0.0,
			1106.4780627798168, 267.65204185321164, 471.48882406487377, -2.4934640349611055, -0.06012601508111928 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector11_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 748.7829710109983, 29.39148550549912, 0.0, 761.4659770738399, 1.2557102096112658, 0.0, 0.4636476090008026, 3.5249475275767503, 0.9999999999999978,
			1092.668146659595, 201.33407332979596, 384.4753146023581, -2.677945044588991, -0.0,
			404.8977953624004, -142.5511023187994, 384.4753146023598, -5.819537698178783, -0.08029273501384664 ),
       new MarkupSegmentLine( 761.4659770738399, 1.2557102096112658, 0.0, 767.2565848853509, -13.102069245006845, 0.0 ),
       new MarkupSegmentLine( 767.2565848853509, -13.102069245006845, 0.0, 779.2332522340887, -41.568985322043304, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector12_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 736.2609903369994, 23.130495168499706, 0.0, 748.8206910526942, -4.750652528402497, 0.0, 0.46364760900081037, 3.524439241428315, 1.0000000000000033,
			397.6692483506499, -146.16537582467686, 378.5570758507743, -5.819537698178776, -0.08080102116228866,
			1099.9721337547362, 136.6640707678709, 378.55707585077175, -2.758746065751271, -0.0 ),
       new MarkupSegmentLine( 748.8206910526942, -4.750652528402497, 0.0, 754.5512567519208, -18.980404324234442, 0.0 ),
       new MarkupSegmentLine( 754.5512567519208, -18.980404324234442, 0.0, 766.4110840780296, -47.18966177401444, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector26_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 740.7667477659113, -58.43101467795671, 0.0, 730.7877792885868, -32.384001937401706, 0.0, 3.5547214858681944, 0.31860125314957544, 0.9999999999999973,
			470.41209525231613, -176.94264317706694, 295.18916684942536, -5.870056474901185, -0.0,
			1011.1214002795083, 60.080613821153165, 295.18916684942695, -2.7284638213113936, -0.09452757912882419 ),
       new MarkupSegmentLine( 730.7877792885868, -32.384001937401706, 0.0, 726.2939442427742, -18.759622057663364, 0.0 ),
       new MarkupSegmentArc( 726.2939442427742, -18.759622057663364, 0.0, 714.175647939635, 6.117098626423399, 0.0, 3.4601939067393612, 0.5880026035475725, 0.9999999999999966,
			824.1346728357134, 13.5119454514508, 103.02554169278856, -2.8229914004402255, -0.0,
			628.4532156498343, -51.03118956677775, 103.02554169278923, -5.964584054030017, 0.26940135039800445 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector27_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 753.5889159219704, -52.81033822598556, 0.0, 735.9155244523233, -31.317043257858543, 0.0, 3.5547214858681953, 0.9632236504568963, 1.0000000000000004,
			800.5073094808522, -32.24337118647571, 51.228271367970294, -2.7284638213113914, -0.0,
			706.6705223630886, -73.37730526549538, 51.228271367970244, -5.870056474901184, 0.5500948181784936 ),
       new MarkupSegmentLine( 735.9155244523233, -31.317043257858543, 0.0, 722.4154245560862, -21.930262700033026, 0.0 ),
       new MarkupSegmentArc( 722.4154245560862, -21.930262700033026, 0.0, 702.5269438189052, -1.6487041207298176, 0.0, 4.104816304046694, 0.588002603547567, 1.000000000000006,
			765.8878134148464, 40.59187560989773, 76.15028806205113, -2.178369003132892, -0.37522104690933317,
			639.1660742229647, -43.88928385135678, 76.15028806205025, -5.695182703632019, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private RoadLanesConnector[] _intersection4_laneConnectors_xjal() {
    return new RoadLanesConnector[] {
      laneConnector33,
      laneConnector34,
      laneConnector35,
      laneConnector37,
      laneConnector29,
      laneConnector31,
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector33_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 198.23360186609258, -704.2953354873407, 0.0, 215.5999350304521, -632.5713211290619, 0.0, 2.883919407263884, -0.2174374194029487, 1.0000000000000009,
			1971.9007256642567, -1171.712788011755, 1834.2230346844042, -3.399265899915703, -0.0,
			-1575.4335219320672, -236.877882962922, 1834.223034684401, -0.25767324632591015, 0.04023582692296146 ),
       new MarkupSegmentLine( 215.5999350304521, -632.5713211290619, 0.0, 215.6021746570953, -632.5611838716242, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector34_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 211.7713992133202, -707.8629737797404, 0.0, 229.27028368671006, -635.5915144368397, 0.0, 2.883919407263881, -0.2174374194029487, 0.9999999999999899,
			1998.9763203590387, -1178.8480645966463, 1848.2230346847437, -3.3992658999157053, -0.0,
			-1575.433521932439, -236.8778829628398, 1848.2230346847814, -0.257673246325908, 0.04023582692295932 ),
       new MarkupSegmentLine( 229.27028368671006, -635.5915144368397, 0.0, 229.27252331335325, -635.5813771794021, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector35_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 256.61322062586913, -641.6217637949579, 0.0, 256.61098099922594, -641.6319010523956, 0.0 ),
       new MarkupSegmentArc( 256.61098099922594, -641.6319010523956, 0.0, 238.84699390777544, -714.9982503645399, 0.0, -0.2174374194029487, 2.8839194072638836, 1.0000000000000109,
			-1575.4335219320408, -236.8778829629278, 1876.223034684374, -0.2174374194029487, -0.040235826922961924,
			2053.127509747553, -1193.1186177661357, 1876.223034684333, -3.3992658999157035, -0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector37_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 242.9428719696112, -638.60157048718, 0.0, 242.94063234296803, -638.6117077446174, 0.0 ),
       new MarkupSegmentArc( 242.94063234296803, -638.6117077446174, 0.0, 225.30919656054783, -711.4306120721402, 0.0, -0.2174374194029458, 2.8839194072638867, 0.9999999999999993,
			2061.31478661776, -1040.345532526254, 1862.2230346841507, -3.3590300729927396, -0.0,
			-1575.43352193183, -236.87788296299516, 1862.2230346841532, -0.21743741940294203, -0.04023582692296419 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector29_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 198.23360186609258, -704.2953354873407, 0.0, 209.90660252519282, -676.8258170106261, 0.0, 2.883919407263885, -0.5459727869082145, 1.000000000000002,
			298.6904052926007, -730.7688842814421, 103.88656381084975, -3.3992658999157013, -0.28829954058230606,
			121.12279975778532, -622.8827497398104, 103.88656381084935, -0.5459727869082142, -0.0 ),
       new MarkupSegmentLine( 209.90660252519282, -676.8258170106261, 0.0, 218.18919198912343, -663.1936706278997, 0.0 ),
       new MarkupSegmentArc( 218.18919198912343, -663.1936706278997, 0.0, 229.27252331335325, -635.5813771794021, 0.0, 2.595619866681579, -0.21743741940294847, 1.0000000000000002,
			295.93683403050414, -710.4314116804276, 90.97307306417842, -3.6875654404980076, -0.0,
			140.44154994774277, -615.9559295753718, 90.97307306417837, -0.5459727869082144, 0.32853536750526624 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _laneConnector31_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentArc( 211.7713992133202, -707.8629737797404, 0.0, 214.54638507250317, -678.2390145487311, 0.0, 2.8839194072638836, 0.070870956267167, 0.9999999999999944,
			123.80407269400638, -684.6807976457027, 90.97067563377288, -0.2576732463259097, 0.32854420259307715,
			305.288697451001, -671.7972314517596, 90.97067563377391, -3.070721697322623, -0.0 ),
       new MarkupSegmentLine( 214.54638507250317, -678.2390145487311, 0.0, 213.4168587391962, -662.3279182212456, 0.0 ),
       new MarkupSegmentArc( 213.4168587391962, -662.3279182212456, 0.0, 215.6021746570953, -632.5611838716242, 0.0, 3.212463609856961, -0.21743741940294825, 0.9999999999999936,
			109.79419430084027, -669.6840755721611, 103.88344255113775, -6.21231435091242, -0.0,
			317.03952317755346, -654.9717608703301, 103.88344255113911, -3.0707216973226275, -0.28830837567011414 ), };
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _rectangle106:
        if (true) {
          ShapeRectangle self = this.rectangle106;
          
navigate(view3D); 
        }
        break;
      case _rectangle107:
        if (true) {
          ShapeRectangle self = this.rectangle107;
          
navigate(view2D); 
        }
        break;
      case _rectangle109:
        if (true) {
          ShapeRectangle self = this.rectangle109;
          
navigate(viewStatistics); 
        }
        break;
      case _rectangle108:
        if (true) {
          ShapeRectangle self = this.rectangle108;
          
navigate(viewLogic); 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _checkbox1: {
          ShapeCheckBox self = this.checkbox1;
roadNetworkDescriptor.set_enableDensityMap(value);
checkbox7.setSelected(value); 
;}
        break;
      case _cbxCameraFollowToCar: {
          ShapeCheckBox self = this.cbxCameraFollowToCar;
selectedCar = null;
if (!value) {
	window3d.setCamera(camera);
	window3d.setNavigationMode(
			Navigation3DType.WINDOW_3D_NAVIGATION_FULL);
} 
;}
        break;
      case _checkbox7: {
          ShapeCheckBox self = this.checkbox7;
roadNetworkDescriptor.set_enableDensityMap(value);
checkbox1.setSelected(value); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
 
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _checkbox1: return 
false 
;
      case _cbxCameraFollowToCar: return 
false 
;
      case _checkbox7: return 
false 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  protected ShapeWindow3D window3d;
  protected ShapeCheckBox checkbox1;
  protected ShapeCheckBox cbxCameraFollowToCar;
  protected ShapeCheckBox checkbox7;
  protected TimePlot plot;
  protected TimePlot plot1;
  protected TimePlot plot2;
  protected TimePlot plot3;
  protected ShapeRectangle rectangle;
  protected Shape3DObject building_1;
  protected Camera3D camera;
  protected ShapeText text1;
  protected ShapeText text2;
  protected ShapeText text3;
  protected ShapeText text6;
  protected Shape3DObject billboard;
  protected Shape3DObject tree_3;
  protected Shape3DObject tree_4;
  protected Shape3DObject tree_5;
  protected Shape3DObject tree_2;
  protected Shape3DObject tree_6;
  protected Shape3DObject tree_7;
  protected Shape3DObject tree_8;
  protected Shape3DObject tree_1;
  protected Shape3DObject tree_9;
  protected Shape3DObject tree_10;
  protected Shape3DObject store;
  protected Shape3DObject building_2;
  protected Shape3DObject building_3;
  protected Shape3DObject building_4;
  protected Shape3DObject hospital;
  protected Shape3DObject auto_service;
  protected Shape3DObject tree_11;
  protected Shape3DObject tree_12;
  protected Shape3DObject tree_13;
  protected Shape3DObject tree_14;
  protected Light3DAmbient light;
  protected Shape3DObject building_5;
  protected Shape3DObject bench;
  protected Shape3DObject bench1;
  protected Shape3DObject bench4;
  protected Shape3DObject bench5;
  protected ShapePolyLine polyline;
  protected Shape3DObject tree_15;
  protected Shape3DObject tree_16;
  protected Shape3DObject tree_17;
  protected Shape3DObject tree_18;
  protected Shape3DObject tree_19;
  protected Shape3DObject tree_20;
  protected ShapePolyLine polyline1;
  protected Shape3DObject warehouse_2;
  protected Shape3DObject tree_21;
  protected Shape3DObject tree_22;
  protected Shape3DObject tree_23;
  protected Shape3DObject tree_24;
  protected Shape3DObject tree_25;
  protected Shape3DObject tree_26;
  protected Shape3DObject tree_27;
  protected Shape3DObject tree_28;
  protected Shape3DObject tree_29;
  protected Shape3DObject tree_30;
  protected Shape3DObject tree_31;
  protected Shape3DObject tree_32;
  protected Shape3DObject tree_33;
  protected Shape3DObject tree_34;
  protected Shape3DObject tree_35;
  protected Shape3DObject tree_36;
  protected Shape3DObject tree_37;
  protected Shape3DObject tree_38;
  protected Shape3DObject tree_39;
  protected Shape3DObject tree_40;
  protected Shape3DObject tree_41;
  protected Shape3DObject tree_42;
  protected Shape3DObject tree_43;
  protected Shape3DObject tree_44;
  protected Shape3DObject tree_45;
  protected Shape3DObject tree_46;
  protected Shape3DObject tree_47;
  protected Shape3DObject tree_48;
  protected Shape3DObject tree_49;
  protected Shape3DObject tree_50;
  protected Shape3DObject tree_51;
  protected Shape3DObject tree_52;
  protected Shape3DObject tree_53;
  protected ShapePolyLine polyline2;
  protected Shape3DObject tree_54;
  protected Shape3DObject bench6;
  protected Shape3DObject tree_55;
  protected Shape3DObject tree_56;
  protected Shape3DObject ad;
  protected Shape3DObject ad1;
  protected Light3DAmbient light1;
  protected ShapeRectangle rectangle105;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle106_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
selectedViewArea == view3D ? new Color(80, 80, 80) : silver 
);
  }
  
  protected ShapeRectangle rectangle106;
  protected ShapeText text96;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle107_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
selectedViewArea == view2D ? new Color(80, 80, 80) : silver 
);
  }
  
  protected ShapeRectangle rectangle107;
  protected ShapeText text97;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle109_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
selectedViewArea == viewStatistics
		? new Color(80, 80, 80)
		: silver 
);
  }
  
  protected ShapeRectangle rectangle109;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle108_SetDynamicParams_xjal( ShapeRectangle shape ) {
    shape.setFillColor(
selectedViewArea == viewLogic
		? new Color(80, 80, 80)
		: silver 
);
  }
  
  protected ShapeRectangle rectangle108;
  protected ShapeText text99;
  protected ShapeText text98;
  protected ShapeRectangle rectangle128;
  protected ShapeText text115;
  protected ShapeGroup groupMainMenu;
  protected Road road4;
  protected StopLine<Agent> stopLine9;
  protected StopLine<Agent> stopLine8;
  protected Road road;
  protected Road road5;
  protected StopLine<Agent> stopLine2;
  protected Road road6;
  protected StopLine<Agent> stopLine5;
  protected Road road7;
  protected StopLine<Agent> stopLine4;
  protected Road road3;
  protected Road road8;
  protected StopLine<Agent> stopLine3;
  protected Road road9;
  protected StopLine<Agent> stopLine6;
  protected Road road10;
  protected StopLine<Agent> stopLine7;
  protected Road road1;
  protected StopLine<Agent> stopLine;
  protected Road road2;
  protected StopLine<Agent> stopLine1;
  protected Road road11;
  protected StopLine<Agent> stopLine10;
  protected Intersection intersection1;
  protected RoadLanesConnector laneConnector;
  protected RoadLanesConnector laneConnector16;
  protected RoadLanesConnector laneConnector17;
  protected RoadLanesConnector laneConnector4;
  protected RoadLanesConnector laneConnector6;
  protected RoadLanesConnector laneConnector25;
  protected Intersection intersection;
  protected RoadLanesConnector laneConnector2;
  protected RoadLanesConnector laneConnector5;
  protected RoadLanesConnector laneConnector3;
  protected RoadLanesConnector laneConnector8;
  protected RoadLanesConnector laneConnector13;
  protected RoadLanesConnector laneConnector14;
  protected RoadLanesConnector laneConnector36;
  protected RoadLanesConnector laneConnector23;
  protected RoadLanesConnector laneConnector41;
  protected RoadLanesConnector laneConnector43;
  protected RoadLanesConnector laneConnector44;
  protected RoadLanesConnector laneConnector45;
  protected RoadLanesConnector laneConnector1;
  protected Intersection intersection2;
  protected RoadLanesConnector laneConnector21;
  protected RoadLanesConnector laneConnector28;
  protected RoadLanesConnector laneConnector19;
  protected RoadLanesConnector laneConnector15;
  protected RoadLanesConnector laneConnector22;
  protected RoadLanesConnector laneConnector30;
  protected RoadLanesConnector laneConnector7;
  protected RoadLanesConnector laneConnector18;
  protected RoadLanesConnector laneConnector20;
  protected Intersection intersection3;
  protected RoadLanesConnector laneConnector9;
  protected RoadLanesConnector laneConnector10;
  protected RoadLanesConnector laneConnector11;
  protected RoadLanesConnector laneConnector12;
  protected RoadLanesConnector laneConnector26;
  protected RoadLanesConnector laneConnector27;
  protected Intersection intersection4;
  protected RoadLanesConnector laneConnector33;
  protected RoadLanesConnector laneConnector34;
  protected RoadLanesConnector laneConnector35;
  protected RoadLanesConnector laneConnector37;
  protected RoadLanesConnector laneConnector29;
  protected RoadLanesConnector laneConnector31;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  protected com.anylogic.engine.markup.RoadNetwork roadNetwork;

  private com.anylogic.engine.markup.RoadNetwork[] _getRoadNetworks_xjal;

  @Override
  public com.anylogic.engine.markup.RoadNetwork[] getRoadNetworks() {
    return _getRoadNetworks_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    camera = new Camera3D( 515.99, 1531.21, 595.6, 0.6988298484774961, -1.5707963267948966 );

    window3d = new ShapeWindow3D( Main.this, false, -1950.0, 50.0, 1150.0, 650.0, WINDOW_3D_NAVIGATION_FULL, 3000.0 );

    checkbox1 = new ShapeCheckBox(
		Main.this,true,835.0, 58.0, 
		120.0, 30.0,
            white, true,
            _checkbox1_Font,
			"Show density map" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox1, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox1, 0 ) );
      }
    };

    cbxCameraFollowToCar = new ShapeCheckBox(
		Main.this,true,-1115.0, 8.0, 
		180.0, 30.0,
            white, true,
            _cbxCameraFollowToCar_Font,
			"Camera on a random car" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _cbxCameraFollowToCar, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _cbxCameraFollowToCar, 0 ) );
      }
    };

    checkbox7 = new ShapeCheckBox(
		Main.this,true,-935.0, 8.0, 
		120.0, 30.0,
            white, true,
            _checkbox7_Font,
			"Show density map" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox7, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox7, 0 ) );
      }
    };

    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,-560.0, -780.0, -2.0, 0.0, 
            null, grassTexture,
			2160.0, 2280.0, 1.0, 1.0, LINE_STYLE_SOLID );

    building_1 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 110.0, 110.0, 0.0, 0.7853981633974483,
			1.0, false, "/city_square/",
			"3d/building_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -60.0, -45.0,
			126.0, 95.0, null, _building_1_customColors_xjal );

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,3150.0, 80.0, 0.0, 0.0, 
        gray,"Cars in system",
        _text1_Font, ALIGNMENT_LEFT );

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,3710.0, 80.0, 0.0, 0.0, 
        gray,"Stops count per car",
        _text2_Font, ALIGNMENT_LEFT );

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,3150.0, 390.0, 0.0, 0.0, 
        gray,"Average speed, km/h",
        _text3_Font, ALIGNMENT_LEFT );

    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,3710.0, 390.0, 0.0, 0.0, 
        gray,"Average time in system, seconds",
        _text6_Font, ALIGNMENT_LEFT );

    billboard = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 350.0, 200.0, 0.0, 5.235987755982989,
			1.5, false, "/city_square/",
			"3d/billboard.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -42.0, -9.0,
			83.0, 17.0, null, _billboard_customColors_xjal );

    tree_3 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 635.0, 180.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_3_customColors_xjal );

    tree_4 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 650.0, 155.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_4_customColors_xjal );

    tree_5 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 615.0, 215.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_5_customColors_xjal );

    tree_2 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 280.0, 350.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_2_customColors_xjal );

    tree_6 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 410.0, 370.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_6_customColors_xjal );

    tree_7 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 400.0, 280.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_7_customColors_xjal );

    tree_8 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 400.0, 480.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_8_customColors_xjal );

    tree_1 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 330.0, 400.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_1_customColors_xjal );

    tree_9 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 340.0, 320.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_9_customColors_xjal );

    tree_10 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 400.0, 430.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_10_customColors_xjal );

    store = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 20.0, 490.0, 0.0, 0.7853981633974483,
			1.0, false, "/city_square/",
			"3d/store.dae", OBJECT_3D_YZX_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -49.0, -28.0,
			97.0, 56.0, null, _store_customColors_xjal );

    building_2 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 510.0, 140.0, 0.0, 0.0,
			0.75, false, "/city_square/",
			"3d/building_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -45.0, -25.0,
			95.0, 55.0, null, _building_2_customColors_xjal );

    building_3 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 740.0, 560.0, 0.0, 0.7853981633974483,
			1.0, false, "/city_square/",
			"3d/building_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -78.0, -78.0,
			166.0, 166.0, null, _building_3_customColors_xjal );

    building_4 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 210.0, 210.0, 0.0, 0.7853981633974483,
			1.0, false, "/city_square/",
			"3d/building_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -60.0, -45.0,
			126.0, 95.0, 1451069231709L, _building_4_customColors_xjal );

    hospital = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 180.0, 820.0, 0.0, 5.183627878423159,
			1.0, false, "/city_square/",
			"3d/hospital.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -69.0, -29.0,
			140.0, 61.0, null, _hospital_customColors_xjal );

    auto_service = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, -70.0, 400.0, 0.0, 3.9269908169872414,
			1.0, false, "/city_square/",
			"3d/auto_service.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -53.0, -38.0,
			111.0, 80.0, null, _auto_service_customColors_xjal );

    tree_11 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 340.0, 620.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_11_customColors_xjal );

    tree_12 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 260.0, 540.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_12_customColors_xjal );

    tree_13 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 180.0, 460.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_13_customColors_xjal );

    tree_14 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 485.0, 710.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_14_customColors_xjal );

    light = new Light3D.Daylight( silver, true, true );

    building_5 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 840.0, 700.0, 0.0, 0.7853981633974483,
			1.0, false, "/city_square/",
			"3d/building_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -60.0, -45.0,
			126.0, 95.0, null, _building_5_customColors_xjal );

    bench = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 210.0, 500.0, 0.0, 3.9269908169872414,
			0.75, false, "/city_square/",
			"3d/bench.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -11.0, -3.0,
			22.0, 5.0, null, _bench_customColors_xjal );

    bench1 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 570.0, 890.0, 0.0, 3.9269908169872414,
			0.75, false, "/city_square/",
			"3d/bench.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -11.0, -3.0,
			22.0, 5.0, null, _bench1_customColors_xjal );

    bench4 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 470.0, 920.0, 0.0, 1.8325957145940461,
			0.75, false, "/city_square/",
			"3d/bench.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -11.0, -3.0,
			22.0, 5.0, null, _bench4_customColors_xjal );

    bench5 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 300.0, 580.0, 0.0, 3.9269908169872414,
			0.75, false, "/city_square/",
			"3d/bench.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -11.0, -3.0,
			22.0, 5.0, null, _bench5_customColors_xjal );

    polyline = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, 130.0, 1520.0, 0.0, null, gravelTexture,
            7, _polyline_pointsDX_xjal(), _polyline_pointsDY_xjal(), _polyline_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID );

    tree_15 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 580.0, 800.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_15_customColors_xjal );

    tree_16 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 655.0, 885.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_16_customColors_xjal );

    tree_17 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 435.0, 815.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_17_customColors_xjal );

    tree_18 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 405.0, 900.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_18_customColors_xjal );

    tree_19 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 535.0, 900.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_19_customColors_xjal );

    tree_20 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 520.0, 840.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_20_customColors_xjal );

    polyline1 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, 560.0, 540.0, 0.0, null, gravelTexture,
            9, _polyline1_pointsDX_xjal(), _polyline1_pointsDY_xjal(), _polyline1_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID );

    warehouse_2 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 800.0, 210.0, 0.0, 5.113814708343385,
			1.0, false, "/city_square/",
			"3d/warehouse_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -57.0, -38.0,
			114.0, 79.0, null, _warehouse_2_customColors_xjal );

    tree_21 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 360.0, 970.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_21_customColors_xjal );

    tree_22 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 310.0, 1075.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_22_customColors_xjal );

    tree_23 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 280.0, 1160.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_23_customColors_xjal );

    tree_24 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 240.0, 1250.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_24_customColors_xjal );

    tree_25 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 190.0, 1355.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_25_customColors_xjal );

    tree_26 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 160.0, 1440.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_26_customColors_xjal );

    tree_27 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 720.0, 940.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_27_customColors_xjal );

    tree_28 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 815.0, 1030.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_28_customColors_xjal );

    tree_29 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 890.0, 1115.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_29_customColors_xjal );

    tree_30 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 960.0, 1200.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_30_customColors_xjal );

    tree_31 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 1055.0, 1290.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_31_customColors_xjal );

    tree_32 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 1130.0, 1375.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_32_customColors_xjal );

    tree_33 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 516.557, 1114.028, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_33_customColors_xjal );

    tree_34 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 569.522, 993.634, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_34_customColors_xjal );

    tree_35 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 480.0, 980.0, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_35_customColors_xjal );

    tree_36 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 673.185, 1031.764, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_36_customColors_xjal );

    tree_37 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 577.794, 1078.673, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_37_customColors_xjal );

    tree_38 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 503.108, 1048.308, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_38_customColors_xjal );

    tree_39 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 624.889, 1018.823, 0.0, 4.974188368183839,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_39_customColors_xjal );

    tree_40 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 660.0, 1240.0, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_40_customColors_xjal );

    tree_41 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 766.066, 1162.219, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_41_customColors_xjal );

    tree_42 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 695.355, 1105.65, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_42_customColors_xjal );

    tree_43 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 836.776, 1247.072, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_43_customColors_xjal );

    tree_44 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 730.71, 1240.001, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_44_customColors_xjal );

    tree_45 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 681.213, 1176.361, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_45_customColors_xjal );

    tree_46 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 801.421, 1211.716, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_46_customColors_xjal );

    tree_47 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 470.0, 1299.999, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_47_customColors_xjal );

    tree_48 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 490.001, 1170.0, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_48_customColors_xjal );

    tree_49 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 400.0, 1180.0, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_49_customColors_xjal );

    tree_50 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 600.0, 1180.001, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_50_customColors_xjal );

    tree_51 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 520.001, 1250.001, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_51_customColors_xjal );

    tree_52 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 440.001, 1240.0, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_1.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -30.0, -33.0,
			59.0, 65.0, null, _tree_52_customColors_xjal );

    tree_53 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 550.0, 1180.0, 0.0, 4.71238898038469,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_53_customColors_xjal );

    polyline2 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -60.0, 1490.0, 0.0, null, gravelTexture,
            6, _polyline2_pointsDX_xjal(), _polyline2_pointsDY_xjal(), _polyline2_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID );

    tree_54 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 100.0, 380.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_54_customColors_xjal );

    bench6 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 140.0, 420.0, 0.0, 3.9269908169872414,
			0.75, false, "/city_square/",
			"3d/bench.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -11.0, -3.0,
			22.0, 5.0, null, _bench6_customColors_xjal );

    tree_55 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 740.0, 320.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_2.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -28.0, -21.0,
			56.0, 42.0, null, _tree_55_customColors_xjal );

    tree_56 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 700.0, 420.0, 0.0, 0.0,
			1.0, false, "/city_square/",
			"3d/tree_3.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -21.0, -19.0,
			41.0, 39.0, null, _tree_56_customColors_xjal );

    ad = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 640.0, 330.0, 0.0, 0.2617993877991494,
			1.0, false, "/city_square/",
			"3d/ad.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -7.0, -3.0,
			14.0, 5.0, null, _ad_customColors_xjal );

    ad1 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 610.0, 680.0, 0.0, 5.497787143782138,
			1.0, false, "/city_square/",
			"3d/ad.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -7.0, -3.0,
			14.0, 5.0, null, _ad1_customColors_xjal );

    light1 = new Light3D.Daylight( _light1_DiffuseColor, true, true );

    rectangle105 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,520.0, 0.0, 0.0, 0.0, 
            null, silver,
			630.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID );

    rectangle106 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,180.0, 0.0, 0.0, 0.0, 
            null, silver,
			60.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties() {
        _rectangle106_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rectangle106, 0, clickx, clicky );
      }
    };

    text96 = new ShapeText(
        SHAPE_DRAW_2D, true,195.0, 10.0, 0.0, 0.0, 
        white,"3D",
        _text96_Font, ALIGNMENT_LEFT );

    rectangle107 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,240.0, 0.0, 0.0, 0.0, 
            null, silver,
			60.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties() {
        _rectangle107_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rectangle107, 0, clickx, clicky );
      }
    };

    text97 = new ShapeText(
        SHAPE_DRAW_2D, true,255.0, 10.0, 0.0, 0.0, 
        white,"2D",
        _text97_Font, ALIGNMENT_LEFT );

    rectangle109 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,300.0, 0.0, 0.0, 0.0, 
            null, silver,
			130.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties() {
        _rectangle109_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rectangle109, 0, clickx, clicky );
      }
    };

    rectangle108 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,430.0, 0.0, 0.0, 0.0, 
            null, silver,
			90.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties() {
        _rectangle108_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rectangle108, 0, clickx, clicky );
      }
    };

    text99 = new ShapeText(
        SHAPE_DRAW_2D, true,315.0, 10.0, 0.0, 0.0, 
        white,"Statistics",
        _text99_Font, ALIGNMENT_LEFT );

    text98 = new ShapeText(
        SHAPE_DRAW_2D, true,445.0, 10.0, 0.0, 0.0, 
        white,"Logic",
        _text98_Font, ALIGNMENT_LEFT );

    rectangle128 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,0.0, 0.0, 0.0, 0.0, 
            null, _rectangle128_Fill_Color,
			180.0, 50.0, 10.0, 1.0, LINE_STYLE_SOLID );

    text115 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 10.0, 0.0, 0.0, 
        white,"City Square",
        _text115_Font, ALIGNMENT_LEFT );

  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    road4 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road4_segments_xjal() );

    road = new Road( this, SHAPE_DRAW_2D3D, true, 2, 3, 0.0, green, _road_segments_xjal() );

    road5 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road5_segments_xjal() );

    road6 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 0, 0.0, green, _road6_segments_xjal() );

    road7 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 0, 0.0, green, _road7_segments_xjal() );

    road3 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 0, 0.0, green, _road3_segments_xjal() );

    road8 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 0, 0.0, green, _road8_segments_xjal() );

    road9 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 0, 0.0, green, _road9_segments_xjal() );

    road10 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road10_segments_xjal() );

    road1 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road1_segments_xjal() );

    road2 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road2_segments_xjal() );

    road11 = new Road( this, SHAPE_DRAW_2D3D, true, 2, 2, 0.0, green, _road11_segments_xjal() );

	laneConnector = new RoadLanesConnector( road7, 0, road, 0, _laneConnector_segments_xjal() );

	laneConnector16 = new RoadLanesConnector( road, 0, road5, 0, _laneConnector16_segments_xjal() );

	laneConnector17 = new RoadLanesConnector( road, 1, road5, 1, _laneConnector17_segments_xjal() );

	laneConnector4 = new RoadLanesConnector( road5, 1, road, 2, _laneConnector4_segments_xjal() );

	laneConnector6 = new RoadLanesConnector( road5, 0, road, 1, _laneConnector6_segments_xjal() );

	laneConnector25 = new RoadLanesConnector( road7, 1, road, 0, _laneConnector25_segments_xjal() );

	laneConnector2 = new RoadLanesConnector( road1, 0, road8, 0, _laneConnector2_segments_xjal() );

	laneConnector5 = new RoadLanesConnector( road6, 1, road1, 1, _laneConnector5_segments_xjal() );

	laneConnector3 = new RoadLanesConnector( road2, 0, road8, 0, _laneConnector3_segments_xjal() );

	laneConnector8 = new RoadLanesConnector( road2, 1, road8, 1, _laneConnector8_segments_xjal() );

	laneConnector13 = new RoadLanesConnector( road6, 0, road2, 0, _laneConnector13_segments_xjal() );

	laneConnector14 = new RoadLanesConnector( road6, 1, road2, 1, _laneConnector14_segments_xjal() );

	laneConnector36 = new RoadLanesConnector( road2, 0, road1, 0, _laneConnector36_segments_xjal() );

	laneConnector23 = new RoadLanesConnector( road5, 0, road2, 0, _laneConnector23_segments_xjal() );

	laneConnector41 = new RoadLanesConnector( road5, 0, road1, 0, _laneConnector41_segments_xjal() );

	laneConnector43 = new RoadLanesConnector( road5, 1, road1, 1, _laneConnector43_segments_xjal() );

	laneConnector44 = new RoadLanesConnector( road1, 0, road5, 0, _laneConnector44_segments_xjal() );

	laneConnector45 = new RoadLanesConnector( road1, 1, road5, 1, _laneConnector45_segments_xjal() );

	laneConnector1 = new RoadLanesConnector( road6, 1, road1, 0, _laneConnector1_segments_xjal() );

	laneConnector21 = new RoadLanesConnector( road8, 0, road9, 0, _laneConnector21_segments_xjal() );

	laneConnector28 = new RoadLanesConnector( road3, 1, road6, 1, _laneConnector28_segments_xjal() );

	laneConnector19 = new RoadLanesConnector( road8, 1, road9, 1, _laneConnector19_segments_xjal() );

	laneConnector15 = new RoadLanesConnector( road3, 0, road4, 0, _laneConnector15_segments_xjal() );

	laneConnector22 = new RoadLanesConnector( road4, 0, road7, 0, _laneConnector22_segments_xjal() );

	laneConnector30 = new RoadLanesConnector( road8, 1, road4, 1, _laneConnector30_segments_xjal() );

	laneConnector7 = new RoadLanesConnector( road4, 1, road6, 0, _laneConnector7_segments_xjal() );

	laneConnector18 = new RoadLanesConnector( road3, 0, road7, 1, _laneConnector18_segments_xjal() );

	laneConnector20 = new RoadLanesConnector( road4, 1, road4, 1, _laneConnector20_segments_xjal() );

	laneConnector9 = new RoadLanesConnector( road10, 0, road3, 0, _laneConnector9_segments_xjal() );

	laneConnector10 = new RoadLanesConnector( road10, 1, road3, 1, _laneConnector10_segments_xjal() );

	laneConnector11 = new RoadLanesConnector( road9, 0, road10, 0, _laneConnector11_segments_xjal() );

	laneConnector12 = new RoadLanesConnector( road9, 1, road10, 1, _laneConnector12_segments_xjal() );

	laneConnector26 = new RoadLanesConnector( road10, 0, road3, 1, _laneConnector26_segments_xjal() );

	laneConnector27 = new RoadLanesConnector( road10, 1, road3, 0, _laneConnector27_segments_xjal() );

	laneConnector33 = new RoadLanesConnector( road11, 0, road4, 0, _laneConnector33_segments_xjal() );

	laneConnector34 = new RoadLanesConnector( road11, 1, road4, 1, _laneConnector34_segments_xjal() );

	laneConnector35 = new RoadLanesConnector( road4, 0, road11, 0, _laneConnector35_segments_xjal() );

	laneConnector37 = new RoadLanesConnector( road4, 1, road11, 1, _laneConnector37_segments_xjal() );

	laneConnector29 = new RoadLanesConnector( road11, 0, road4, 1, _laneConnector29_segments_xjal() );

	laneConnector31 = new RoadLanesConnector( road11, 1, road4, 0, _laneConnector31_segments_xjal() );

    intersection1 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road, PathEndType.END ),
			new PathEnd( road5, PathEndType.BEGIN ),
			new PathEnd( road7, PathEndType.END ),
		}, _intersection1_laneConnectors_xjal()
 );

    intersection = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road5, PathEndType.END ),
			new PathEnd( road6, PathEndType.END ),
			new PathEnd( road8, PathEndType.BEGIN ),
			new PathEnd( road1, PathEndType.BEGIN ),
			new PathEnd( road2, PathEndType.END ),
		}, _intersection_laneConnectors_xjal()
 );

    intersection2 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road4, PathEndType.BEGIN ),
			new PathEnd( road6, PathEndType.BEGIN ),
			new PathEnd( road7, PathEndType.BEGIN ),
			new PathEnd( road3, PathEndType.END ),
			new PathEnd( road8, PathEndType.END ),
			new PathEnd( road9, PathEndType.BEGIN ),
		}, _intersection2_laneConnectors_xjal()
 );

    intersection3 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road3, PathEndType.BEGIN ),
			new PathEnd( road9, PathEndType.END ),
			new PathEnd( road10, PathEndType.BEGIN ),
		}, _intersection3_laneConnectors_xjal()
 );

    intersection4 = new Intersection( this, SHAPE_DRAW_2D3D, true, true, new PathEnd[] {
			new PathEnd( road4, PathEndType.END ),
			new PathEnd( road11, PathEndType.BEGIN ),
		}, _intersection4_laneConnectors_xjal()
 );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<>( 1 );
    _items.add( _plot_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Cars in system" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( dodgerBlue, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot = new TimePlot(
		    Main.this, true, 3100.0, 90.0, 
			570.0, 290.0,
            null, null,
            50.0, 30.0,
			490.0000000000001, 200.0, whiteSmoke, black, black,
            30.0, Chart.SOUTH,
            
1 
             * hour(), Chart.WINDOW_MOVES_WITH_TIME, Chart.DEFAULT_TIME_PATTERN, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<>( 1 );
    _items.add( _plot1_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Average speed, km/h" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( dodgerBlue, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot1 = new TimePlot(
		    Main.this, true, 3100.0, 400.0, 
			570.0, 290.0,
            null, null,
            50.0, 30.0,
			490.0000000000001, 200.0, whiteSmoke, black, black,
            30.0, Chart.SOUTH,
            
1 
             * hour(), Chart.WINDOW_MOVES_WITH_TIME, Chart.DEFAULT_TIME_PATTERN, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<>( 1 );
    _items.add( _plot2_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Average time in system, seconds" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( dodgerBlue, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot2 = new TimePlot(
		    Main.this, true, 3660.0, 400.0, 
			570.0, 290.0,
            null, null,
            50.0, 30.0,
			490.0000000000001, 200.0, whiteSmoke, black, black,
            30.0, Chart.SOUTH,
            
1 
             * hour(), Chart.WINDOW_MOVES_WITH_TIME, Chart.DEFAULT_TIME_PATTERN, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<>( 1 );
    _items.add( _plot3_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<>( 1 );
    _titles.add( "Stops count per car" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( dodgerBlue, true, true, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot3 = new TimePlot(
		    Main.this, true, 3660.0, 90.0, 
			570.0, 290.0,
            null, null,
            50.0, 30.0,
			490.0, 200.0, whiteSmoke, black, black,
            30.0, Chart.SOUTH,
            
1 
             * hour(), Chart.WINDOW_MOVES_WITH_TIME, Chart.DEFAULT_TIME_PATTERN, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );

    }
    {
    groupMainMenu = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, -180.0, 50.0, 0.0, 0.0
	
	     , rectangle105
	     , rectangle106
	     , text96
	     , rectangle107
	     , text97
	     , rectangle109
	     , rectangle108
	     , text99
	     , text98
	     , rectangle128
	     , text115 );

    }
    {
    stopLine9 = new StopLine<Agent>( road4, _stopLine9_controller_xjal, SHAPE_DRAW_2D3D, true, false, 7.781, 0, 1, RoadSignType.newYield() );

    }
    {
    stopLine8 = new StopLine<Agent>( road4, _stopLine8_controller_xjal, SHAPE_DRAW_2D3D, true, true, 798.0716599661648, 0, 1 );

    }
    {
    stopLine2 = new StopLine<Agent>( road5, _stopLine2_controller_xjal, SHAPE_DRAW_2D3D, true, true, 141.99572654847898, 0, 1 );

    }
    {
    stopLine5 = new StopLine<Agent>( road6, _stopLine5_controller_xjal, SHAPE_DRAW_2D3D, true, true, 185.0, 0, 1, RoadSignType.newYield() );

    }
    {
    stopLine4 = new StopLine<Agent>( road7, _stopLine4_controller_xjal, SHAPE_DRAW_2D3D, true, true, 111.021, 0, 1, RoadSignType.newYield() );

    }
    {
    stopLine3 = new StopLine<Agent>( road8, _stopLine3_controller_xjal, SHAPE_DRAW_2D3D, true, true, 130.7737973711325, 0, 1 );

    }
    {
    stopLine6 = new StopLine<Agent>( road9, _stopLine6_controller_xjal, SHAPE_DRAW_2D3D, true, true, 253.32815729997475, 0, 1 );

    }
    {
    stopLine7 = new StopLine<Agent>( road10, _stopLine7_controller_xjal, SHAPE_DRAW_2D3D, true, false, 15.0, 0, 1 );

    }
    {
    stopLine = new StopLine<Agent>( road1, _stopLine_controller_xjal, SHAPE_DRAW_2D3D, true, false, 10.0, 0, 1 );

    }
    {
    stopLine1 = new StopLine<Agent>( road2, _stopLine1_controller_xjal, SHAPE_DRAW_2D3D, true, true, 907.8779875342909, 0, 1 );

    }
    {
    stopLine10 = new StopLine<Agent>( road11, _stopLine10_controller_xjal, SHAPE_DRAW_2D3D, true, false, 8.0, 0, 1 );

    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
	roadNetwork = new com.anylogic.engine.markup.RoadNetwork(this, "roadNetwork", SHAPE_DRAW_2D3D, false, true, ROAD_RIGHT_HAND, 3.5, tarmacTexture, white, ROAD_LINE_SINGLE_DASHED, white, ROAD_LINE_SINGLE, true);
	_getRoadNetworks_xjal = new com.anylogic.engine.markup.RoadNetwork[] { 
      roadNetwork };
    _createPersistentElementsBP0_xjal();
    _createPersistentElementsBP1_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getCameras3D(Map<String, Camera3D> _output) {
    if ( _output != null ) {
      _output.put( "camera", this.camera );
    }
    return 1 + super.getCameras3D( _output );
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	
  public TrafficLight<StopLine> trafficLight;
  private TrafficLight<StopLine> _trafficLight_xjal() {
	return new TrafficLight<StopLine>(new StopLine[] {
      stopLine2,
      stopLine5,
      stopLine,
      stopLine1,
    }, new double[7], new TrafficLightSignal[][] {
					{ SIGNAL_GREEN, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED,  },
					{ SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_GREEN, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED,  },
					{ SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_GREEN, SIGNAL_YELLOW, SIGNAL_RED,  },
					{ SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_RED, SIGNAL_YELLOW, SIGNAL_GREEN,  },
		}) {
    @Override
    @AnyLogicInternalCodegenAPI
    public double calcPhaseDurationInSeconds(int index) {
        return _trafficLight_phaseDuration_xjal(this, index);
    }
    };
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _trafficLight_phaseDuration_xjal(TrafficLight self, int index) {
	switch (index) {
	  case 0: {
		return 
30 
;
	  }
	  case 1: {
		return 
5 
;
	  }
	  case 2: {
		return 
50 
;
	  }
	  case 3: {
		return 
5 
;
	  }
	  case 4: {
		return 
30 
;
	  }
	  case 5: {
		return 
5 
;
	  }
	  case 6: {
		return 
30 
;
	  }
	}
	throw new IndexOutOfBoundsException();
  }	
  public TrafficLight<StopLine> trafficLight1;
  private TrafficLight<StopLine> _trafficLight1_xjal() {
	return new TrafficLight<StopLine>(new StopLine[] {
      stopLine3,
    }, new double[2], new TrafficLightSignal[][] {
					{ SIGNAL_RED, SIGNAL_RED,  },
		}) {
    @Override
    @AnyLogicInternalCodegenAPI
    public double calcPhaseDurationInSeconds(int index) {
        return _trafficLight1_phaseDuration_xjal(this, index);
    }
    };
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _trafficLight1_phaseDuration_xjal(TrafficLight self, int index) {
	switch (index) {
	  case 0: {
		return 
10 
;
	  }
	  case 1: {
		return 
15 
;
	  }
	}
	throw new IndexOutOfBoundsException();
  }	


  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    carSourceNorthCentral = instantiate_carSourceNorthCentral_xjal();
    carMoveToNorthWest = instantiate_carMoveToNorthWest_xjal();
    carDispose = instantiate_carDispose_xjal();
    carMoveToSouthWest = instantiate_carMoveToSouthWest_xjal();
    carSourceNorthWest = instantiate_carSourceNorthWest_xjal();
    carMoveToSouthEast1 = instantiate_carMoveToSouthEast1_xjal();
    carSourceSouthEast = instantiate_carSourceSouthEast_xjal();
    carMoveToNorthEast = instantiate_carMoveToNorthEast_xjal();
    carSourceSouthWest = instantiate_carSourceSouthWest_xjal();
    carMoveToNorthCenter = instantiate_carMoveToNorthCenter_xjal();
    selectOutput7 = instantiate_selectOutput7_xjal();
    carSourceNorthEast = instantiate_carSourceNorthEast_xjal();
    selectOutput = instantiate_selectOutput_xjal();
    roadNetworkDescriptor = instantiate_roadNetworkDescriptor_xjal();
    busSourceNorthEast = instantiate_busSourceNorthEast_xjal();
    carWayNotFoundDispose = instantiate_carWayNotFoundDispose_xjal();
    selectOutput2 = instantiate_selectOutput2_xjal();
    truckSourceNorthEast = instantiate_truckSourceNorthEast_xjal();
    truckSourceNorthWest = instantiate_truckSourceNorthWest_xjal();
    _stopLine9_controller_xjal = instantiate__stopLine9_controller_xjal_xjal();
    _stopLine8_controller_xjal = instantiate__stopLine8_controller_xjal_xjal();
    _stopLine2_controller_xjal = instantiate__stopLine2_controller_xjal_xjal();
    _stopLine5_controller_xjal = instantiate__stopLine5_controller_xjal_xjal();
    _stopLine4_controller_xjal = instantiate__stopLine4_controller_xjal_xjal();
    _stopLine3_controller_xjal = instantiate__stopLine3_controller_xjal_xjal();
    _stopLine6_controller_xjal = instantiate__stopLine6_controller_xjal_xjal();
    _stopLine7_controller_xjal = instantiate__stopLine7_controller_xjal_xjal();
    _stopLine_controller_xjal = instantiate__stopLine_controller_xjal_xjal();
    _stopLine1_controller_xjal = instantiate__stopLine1_controller_xjal_xjal();
    _stopLine10_controller_xjal = instantiate__stopLine10_controller_xjal_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
	_initialize_roadNetwork_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    presentation.getConfiguration3D().setBackgroundColor( oliveDrab );
    window3d.setCamera( camera, false );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "city_square.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Creating non-replicated embedded objects
    setupParameters_carSourceNorthCentral_xjal( carSourceNorthCentral, null );
    doBeforeCreate_carSourceNorthCentral_xjal( carSourceNorthCentral, null );
    carSourceNorthCentral.createAsEmbedded();
    setupParameters_carMoveToNorthWest_xjal( carMoveToNorthWest, null );
    doBeforeCreate_carMoveToNorthWest_xjal( carMoveToNorthWest, null );
    carMoveToNorthWest.createAsEmbedded();
    setupParameters_carDispose_xjal( carDispose, null );
    doBeforeCreate_carDispose_xjal( carDispose, null );
    carDispose.createAsEmbedded();
    setupParameters_carMoveToSouthWest_xjal( carMoveToSouthWest, null );
    doBeforeCreate_carMoveToSouthWest_xjal( carMoveToSouthWest, null );
    carMoveToSouthWest.createAsEmbedded();
    setupParameters_carSourceNorthWest_xjal( carSourceNorthWest, null );
    doBeforeCreate_carSourceNorthWest_xjal( carSourceNorthWest, null );
    carSourceNorthWest.createAsEmbedded();
    setupParameters_carMoveToSouthEast1_xjal( carMoveToSouthEast1, null );
    doBeforeCreate_carMoveToSouthEast1_xjal( carMoveToSouthEast1, null );
    carMoveToSouthEast1.createAsEmbedded();
    setupParameters_carSourceSouthEast_xjal( carSourceSouthEast, null );
    doBeforeCreate_carSourceSouthEast_xjal( carSourceSouthEast, null );
    carSourceSouthEast.createAsEmbedded();
    setupParameters_carMoveToNorthEast_xjal( carMoveToNorthEast, null );
    doBeforeCreate_carMoveToNorthEast_xjal( carMoveToNorthEast, null );
    carMoveToNorthEast.createAsEmbedded();
    setupParameters_carSourceSouthWest_xjal( carSourceSouthWest, null );
    doBeforeCreate_carSourceSouthWest_xjal( carSourceSouthWest, null );
    carSourceSouthWest.createAsEmbedded();
    setupParameters_carMoveToNorthCenter_xjal( carMoveToNorthCenter, null );
    doBeforeCreate_carMoveToNorthCenter_xjal( carMoveToNorthCenter, null );
    carMoveToNorthCenter.createAsEmbedded();
    setupParameters_selectOutput7_xjal( selectOutput7, null );
    doBeforeCreate_selectOutput7_xjal( selectOutput7, null );
    selectOutput7.createAsEmbedded();
    setupParameters_carSourceNorthEast_xjal( carSourceNorthEast, null );
    doBeforeCreate_carSourceNorthEast_xjal( carSourceNorthEast, null );
    carSourceNorthEast.createAsEmbedded();
    setupParameters_selectOutput_xjal( selectOutput, null );
    doBeforeCreate_selectOutput_xjal( selectOutput, null );
    selectOutput.createAsEmbedded();
    setupParameters_roadNetworkDescriptor_xjal( roadNetworkDescriptor, null );
    doBeforeCreate_roadNetworkDescriptor_xjal( roadNetworkDescriptor, null );
    roadNetworkDescriptor.createAsEmbedded();
    setupParameters_busSourceNorthEast_xjal( busSourceNorthEast, null );
    doBeforeCreate_busSourceNorthEast_xjal( busSourceNorthEast, null );
    busSourceNorthEast.createAsEmbedded();
    setupParameters_carWayNotFoundDispose_xjal( carWayNotFoundDispose, null );
    doBeforeCreate_carWayNotFoundDispose_xjal( carWayNotFoundDispose, null );
    carWayNotFoundDispose.createAsEmbedded();
    setupParameters_selectOutput2_xjal( selectOutput2, null );
    doBeforeCreate_selectOutput2_xjal( selectOutput2, null );
    selectOutput2.createAsEmbedded();
    setupParameters_truckSourceNorthEast_xjal( truckSourceNorthEast, null );
    doBeforeCreate_truckSourceNorthEast_xjal( truckSourceNorthEast, null );
    truckSourceNorthEast.createAsEmbedded();
    setupParameters_truckSourceNorthWest_xjal( truckSourceNorthWest, null );
    doBeforeCreate_truckSourceNorthWest_xjal( truckSourceNorthWest, null );
    truckSourceNorthWest.createAsEmbedded();
    setupParameters__stopLine9_controller_xjal_xjal( _stopLine9_controller_xjal, null );
    doBeforeCreate__stopLine9_controller_xjal_xjal( _stopLine9_controller_xjal, null );
    _stopLine9_controller_xjal.createAsEmbedded();
    setupParameters__stopLine8_controller_xjal_xjal( _stopLine8_controller_xjal, null );
    doBeforeCreate__stopLine8_controller_xjal_xjal( _stopLine8_controller_xjal, null );
    _stopLine8_controller_xjal.createAsEmbedded();
    setupParameters__stopLine2_controller_xjal_xjal( _stopLine2_controller_xjal, null );
    doBeforeCreate__stopLine2_controller_xjal_xjal( _stopLine2_controller_xjal, null );
    _stopLine2_controller_xjal.createAsEmbedded();
    setupParameters__stopLine5_controller_xjal_xjal( _stopLine5_controller_xjal, null );
    doBeforeCreate__stopLine5_controller_xjal_xjal( _stopLine5_controller_xjal, null );
    _stopLine5_controller_xjal.createAsEmbedded();
    setupParameters__stopLine4_controller_xjal_xjal( _stopLine4_controller_xjal, null );
    doBeforeCreate__stopLine4_controller_xjal_xjal( _stopLine4_controller_xjal, null );
    _stopLine4_controller_xjal.createAsEmbedded();
    setupParameters__stopLine3_controller_xjal_xjal( _stopLine3_controller_xjal, null );
    doBeforeCreate__stopLine3_controller_xjal_xjal( _stopLine3_controller_xjal, null );
    _stopLine3_controller_xjal.createAsEmbedded();
    setupParameters__stopLine6_controller_xjal_xjal( _stopLine6_controller_xjal, null );
    doBeforeCreate__stopLine6_controller_xjal_xjal( _stopLine6_controller_xjal, null );
    _stopLine6_controller_xjal.createAsEmbedded();
    setupParameters__stopLine7_controller_xjal_xjal( _stopLine7_controller_xjal, null );
    doBeforeCreate__stopLine7_controller_xjal_xjal( _stopLine7_controller_xjal, null );
    _stopLine7_controller_xjal.createAsEmbedded();
    setupParameters__stopLine_controller_xjal_xjal( _stopLine_controller_xjal, null );
    doBeforeCreate__stopLine_controller_xjal_xjal( _stopLine_controller_xjal, null );
    _stopLine_controller_xjal.createAsEmbedded();
    setupParameters__stopLine1_controller_xjal_xjal( _stopLine1_controller_xjal, null );
    doBeforeCreate__stopLine1_controller_xjal_xjal( _stopLine1_controller_xjal, null );
    _stopLine1_controller_xjal.createAsEmbedded();
    setupParameters__stopLine10_controller_xjal_xjal( _stopLine10_controller_xjal, null );
    doBeforeCreate__stopLine10_controller_xjal_xjal( _stopLine10_controller_xjal, null );
    _stopLine10_controller_xjal.createAsEmbedded();
	 // Port connectors with non-replicated objects
    carDispose.in.connect( carMoveToNorthWest.out ); // connector1
    selectOutput7.in.connect( carSourceNorthCentral.out ); // connector2
    carMoveToSouthWest.out.connect( carDispose.in ); // connector4
    carMoveToSouthEast1.out.connect( carDispose.in ); // connector6
    carMoveToNorthEast.out.connect( carDispose.in ); // connector8
    carMoveToNorthCenter.out.connect( carDispose.in ); // connector10
    selectOutput2.outF.connect( carMoveToNorthCenter.in ); // connector14
    selectOutput.outT.connect( carMoveToNorthWest.in ); // connector16
    selectOutput.outF.connect( carMoveToNorthEast.in ); // connector18
    selectOutput7.out3.connect( carMoveToSouthEast1.in ); // connector21
    selectOutput7.out2.connect( carMoveToSouthWest.in ); // connector20
    carMoveToSouthWest.outWayNotFound.connect( carWayNotFoundDispose.in ); // connector25
    selectOutput7.out1.connect( carMoveToNorthWest.in ); // connector33
    carMoveToNorthWest.outWayNotFound.connect( carWayNotFoundDispose.in ); // connector34
    carMoveToSouthEast1.outWayNotFound.connect( carMoveToSouthWest.in ); // connector35
    carMoveToNorthEast.outWayNotFound.connect( carWayNotFoundDispose.in ); // connector36
    carMoveToNorthCenter.outWayNotFound.connect( carMoveToNorthEast.in ); // connector38
    selectOutput2.outT.connect( carMoveToNorthEast.in ); // connector13
    carSourceNorthEast.out.connect( selectOutput7.in ); // connector5
    carSourceNorthWest.out.connect( carMoveToSouthEast1.in ); // connector7
    carSourceSouthEast.out.connect( selectOutput.in ); // connector9
    carSourceSouthWest.out.connect( selectOutput2.in ); // connector11
    busSourceNorthEast.out.connect( selectOutput7.in ); // connector12
    truckSourceNorthEast.out.connect( selectOutput7.in ); // connector
    truckSourceNorthWest.out.connect( carMoveToSouthEast1.in ); // connector3
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    checkbox1.setValueToDefault();
    cbxCameraFollowToCar.setValueToDefault();
    checkbox7.setValueToDefault();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _plot_autoUpdateEvent_xjal.start();
    _plot1_autoUpdateEvent_xjal.start();
    _plot2_autoUpdateEvent_xjal.start();
    _plot3_autoUpdateEvent_xjal.start();
    carSourceNorthCentral.startAsEmbedded();
    carMoveToNorthWest.startAsEmbedded();
    carDispose.startAsEmbedded();
    carMoveToSouthWest.startAsEmbedded();
    carSourceNorthWest.startAsEmbedded();
    carMoveToSouthEast1.startAsEmbedded();
    carSourceSouthEast.startAsEmbedded();
    carMoveToNorthEast.startAsEmbedded();
    carSourceSouthWest.startAsEmbedded();
    carMoveToNorthCenter.startAsEmbedded();
    selectOutput7.startAsEmbedded();
    carSourceNorthEast.startAsEmbedded();
    selectOutput.startAsEmbedded();
    roadNetworkDescriptor.startAsEmbedded();
    busSourceNorthEast.startAsEmbedded();
    carWayNotFoundDispose.startAsEmbedded();
    selectOutput2.startAsEmbedded();
    truckSourceNorthEast.startAsEmbedded();
    truckSourceNorthWest.startAsEmbedded();
    _stopLine9_controller_xjal.startAsEmbedded();
    _stopLine8_controller_xjal.startAsEmbedded();
    _stopLine2_controller_xjal.startAsEmbedded();
    _stopLine5_controller_xjal.startAsEmbedded();
    _stopLine4_controller_xjal.startAsEmbedded();
    _stopLine3_controller_xjal.startAsEmbedded();
    _stopLine6_controller_xjal.startAsEmbedded();
    _stopLine7_controller_xjal.startAsEmbedded();
    _stopLine_controller_xjal.startAsEmbedded();
    _stopLine1_controller_xjal.startAsEmbedded();
    _stopLine10_controller_xjal.startAsEmbedded();
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
navigate(view3D); 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    carStopsCounter = 
0 
;
    selectedCar = 
null 
;
    selectedViewArea = 
view2D 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( carSourceNorthCentral );
    list.add( carMoveToNorthWest );
    list.add( carDispose );
    list.add( carMoveToSouthWest );
    list.add( carSourceNorthWest );
    list.add( carMoveToSouthEast1 );
    list.add( carSourceSouthEast );
    list.add( carMoveToNorthEast );
    list.add( carSourceSouthWest );
    list.add( carMoveToNorthCenter );
    list.add( selectOutput7 );
    list.add( carSourceNorthEast );
    list.add( selectOutput );
    list.add( roadNetworkDescriptor );
    list.add( busSourceNorthEast );
    list.add( carWayNotFoundDispose );
    list.add( selectOutput2 );
    list.add( truckSourceNorthEast );
    list.add( truckSourceNorthWest );
    list.add( _stopLine9_controller_xjal );
    list.add( _stopLine8_controller_xjal );
    list.add( _stopLine2_controller_xjal );
    list.add( _stopLine5_controller_xjal );
    list.add( _stopLine4_controller_xjal );
    list.add( _stopLine3_controller_xjal );
    list.add( _stopLine6_controller_xjal );
    list.add( _stopLine7_controller_xjal );
    list.add( _stopLine_controller_xjal );
    list.add( _stopLine1_controller_xjal );
    list.add( _stopLine10_controller_xjal );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot1_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot2_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot3_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _plot_autoUpdateEvent_xjal.onDestroy();
    _plot1_autoUpdateEvent_xjal.onDestroy();
    _plot2_autoUpdateEvent_xjal.onDestroy();
    _plot3_autoUpdateEvent_xjal.onDestroy();
    carSourceNorthCentral.onDestroy();
    carMoveToNorthWest.onDestroy();
    carDispose.onDestroy();
    carMoveToSouthWest.onDestroy();
    carSourceNorthWest.onDestroy();
    carMoveToSouthEast1.onDestroy();
    carSourceSouthEast.onDestroy();
    carMoveToNorthEast.onDestroy();
    carSourceSouthWest.onDestroy();
    carMoveToNorthCenter.onDestroy();
    selectOutput7.onDestroy();
    carSourceNorthEast.onDestroy();
    selectOutput.onDestroy();
    roadNetworkDescriptor.onDestroy();
    busSourceNorthEast.onDestroy();
    carWayNotFoundDispose.onDestroy();
    selectOutput2.onDestroy();
    truckSourceNorthEast.onDestroy();
    truckSourceNorthWest.onDestroy();
    _stopLine9_controller_xjal.onDestroy();
    _stopLine8_controller_xjal.onDestroy();
    _stopLine2_controller_xjal.onDestroy();
    _stopLine5_controller_xjal.onDestroy();
    _stopLine4_controller_xjal.onDestroy();
    _stopLine3_controller_xjal.onDestroy();
    _stopLine6_controller_xjal.onDestroy();
    _stopLine7_controller_xjal.onDestroy();
    _stopLine_controller_xjal.onDestroy();
    _stopLine1_controller_xjal.onDestroy();
    _stopLine10_controller_xjal.onDestroy();
  // Analysis Data Elements
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot1_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot2_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot3_expression0_dataSet_xjal.destroyUpdater_xjal();
    speedDS.destroyUpdater_xjal();
    timeInSystemDS.destroyUpdater_xjal();
    carStopsDS.destroyUpdater_xjal();
    logToDB( speedDS, "speedDS" );
    logToDB( timeInSystemDS, "timeInSystemDS" );
    logToDB( carStopsDS, "carStopsDS" );
    logToDB( _plot_expression0_dataSet_xjal, "plot : Cars in system" );
    logToDB( _plot1_expression0_dataSet_xjal, "plot1 : Average speed, km/h" );
    logToDB( _plot2_expression0_dataSet_xjal, "plot2 : Average time in system, seconds" );
    logToDB( _plot3_expression0_dataSet_xjal, "plot3 : Stops count per car" );
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    carSourceNorthCentral.doFinish();
    carMoveToNorthWest.doFinish();
    carDispose.doFinish();
    carMoveToSouthWest.doFinish();
    carSourceNorthWest.doFinish();
    carMoveToSouthEast1.doFinish();
    carSourceSouthEast.doFinish();
    carMoveToNorthEast.doFinish();
    carSourceSouthWest.doFinish();
    carMoveToNorthCenter.doFinish();
    selectOutput7.doFinish();
    carSourceNorthEast.doFinish();
    selectOutput.doFinish();
    roadNetworkDescriptor.doFinish();
    busSourceNorthEast.doFinish();
    carWayNotFoundDispose.doFinish();
    selectOutput2.doFinish();
    truckSourceNorthEast.doFinish();
    truckSourceNorthWest.doFinish();
    _stopLine9_controller_xjal.doFinish();
    _stopLine8_controller_xjal.doFinish();
    _stopLine2_controller_xjal.doFinish();
    _stopLine5_controller_xjal.doFinish();
    _stopLine4_controller_xjal.doFinish();
    _stopLine3_controller_xjal.doFinish();
    _stopLine6_controller_xjal.doFinish();
    _stopLine7_controller_xjal.doFinish();
    _stopLine_controller_xjal.doFinish();
    _stopLine1_controller_xjal.doFinish();
    _stopLine10_controller_xjal.doFinish();
  }


}
